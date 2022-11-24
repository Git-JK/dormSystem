package seckill.dormsystem.service;

import seckill.dormsystem.domain.dto.LoginDto;
import seckill.dormsystem.domain.dto.RefreshTokenDto;
import seckill.dormsystem.exception.ServiceException;

public interface TokenService {
    /**
     * 刷新refreshToken
     * @param refreshToken
     * @return 新的refreshToken
     */
    RefreshTokenDto refreshToken(RefreshTokenDto refreshTokenDto) throws ServiceException;

    /**
     * 生成accessToken
     * @param uid
     * @return accessToken
     */
    String generateAccessToken(String uid);

    /**
     * 生成refreshToken
     * @param uid
     * @return refreshToken
     */
    String generateRefreshToken(String uid);

    /**
     * 获得accessToken保持时间
     * @return
     */
    long getAccessExpiration();

    /**
     * 获得refreshToken保持时间
     * @return
     */
    long getRefreshExpiration();

    /**
     * 检验token合法性
     * @param token
     * @return 检验结果
     */
    Boolean checkToken(String token);

    /**
     * 获取token中的claim信息
     * @param token
     * @param key
     * @return
     */
    String getClaim(String token, String key);
}
