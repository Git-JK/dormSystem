package seckill.dormsystem.service.impl;

import org.springframework.stereotype.Service;
import seckill.dormsystem.common.utils.JwtTokenUtil;
import seckill.dormsystem.service.RedisService;
import seckill.dormsystem.service.TokenService;

import javax.annotation.Resource;
import java.util.List;

@Service
public class TokenServiceImpl implements TokenService {
    @Resource
    private RedisService redisService;

    @Override
    public String refreshToken(String refreshToken) {
        String uid = JwtTokenUtil.getClaim(refreshToken, "uid");
        if(uid == null) {
            return null;
        }
        List<String> refreshTokenList = (List<String>)(List) redisService.listGet(uid);
        if(!refreshTokenList.contains(refreshToken)) {
            return null;
        }
        String newToken = JwtTokenUtil.generateRefreshToken(uid);
        refreshTokenList.remove(refreshToken);
        refreshTokenList.add(newToken);
        redisService.delete(uid);
        redisService.listPushAll(uid, refreshTokenList);
        return newToken;
    }
}
