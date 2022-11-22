package seckill.dormsystem.service;

public interface TokenService {
    /**
     * 刷新refreshToken
     * @param refreshToken
     * @return
     */
    String refreshToken(String refreshToken);
}
