package seckill.dormsystem.service.impl;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import seckill.dormsystem.common.utils.JwtTokenUtil;
import seckill.dormsystem.domain.dto.LoginDto;
import seckill.dormsystem.domain.dto.RefreshTokenDto;
import seckill.dormsystem.exception.ServiceException;
import seckill.dormsystem.exception.TokenException;
import seckill.dormsystem.service.RedisService;
import seckill.dormsystem.service.TokenService;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;

@Service
public class TokenServiceImpl implements TokenService {
    @Resource
    private RedisService redisService;

    @Value("${token.accessExpiration}")
    private Integer accessExpiration;

    @Value("${token.refreshExpiration}")
    private Integer refreshExpiration;

    @Override
    public RefreshTokenDto refreshToken(RefreshTokenDto refreshTokenDto) throws ServiceException {
        String refreshToken = refreshTokenDto.getRefreshToken();
        Boolean verifyResult = checkToken(refreshToken);
        if(!verifyResult) {
            throw new TokenException("token过期，请重新登录");
        }
        String uid = getClaim(refreshToken, "uid");
        if(uid == null) {
            throw new TokenException("未处于登录状态，请重试");
        }
        List<String> refreshTokenList = (List<String>)(List) redisService.listGet(uid);
        if(!refreshTokenList.contains(refreshToken)) {
            throw new TokenException("未处于登录状态，请重试");
        }
        String newAccessToken = generateAccessToken(uid);
        redisService.set(newAccessToken, "", accessExpiration, TimeUnit.SECONDS);
        String newRefreshToken = generateRefreshToken(uid);
        redisService.listRemove(uid, 0, refreshToken);
        redisService.listPush(uid, newRefreshToken);
        RefreshTokenDto newToken = new RefreshTokenDto();
        newToken.setAccessToken(newAccessToken);
        newToken.setRefreshToken(newRefreshToken);
//        refreshTokenList.remove(refreshToken);
//        refreshTokenList.add(newToken);
//        redisService.delete(uid);
//        redisService.listPushAll(uid, refreshTokenList);
        return newToken;
    }

    @Override
    public String generateAccessToken(String uid) {
        String accessToken = JwtTokenUtil.generateToken(new HashMap<String, Object>(){{
            put("uid", uid);
        }}, accessExpiration);
        redisService.set(accessToken, "", accessExpiration, TimeUnit.SECONDS);
        return accessToken;
    }

    @Override
    public String generateRefreshToken(String uid) {
        String refreshToken = JwtTokenUtil.generateToken(new HashMap<String, Object>(){{
            put("uid", uid);
        }}, refreshExpiration);
        redisService.listPush(uid, refreshToken);
        return refreshToken;
    }

    @Override
    public long getAccessExpiration() {
        return accessExpiration;
    }

    @Override
    public long getRefreshExpiration() {
        return refreshExpiration;
    }

    @Override
    public Boolean checkToken(String token) {
        return JwtTokenUtil.checkToken(token);
    }

    @Override
    public String getClaim(String token, String key) {
        return JwtTokenUtil.getClaim(token, key);
    }
}
