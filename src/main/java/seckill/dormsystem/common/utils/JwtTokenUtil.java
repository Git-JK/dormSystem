package seckill.dormsystem.common.utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTCreator;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTDecodeException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;

import java.util.Date;
import java.util.Map;

public class JwtTokenUtil {
    private static String tokenSecret = "dorm-system";
    public static String generateToken(Map<String, Object> claims, long expireTime) {
        String token = null;
        try {
            Date issuedAt = new Date(System.currentTimeMillis());
            Date expireAt = new Date(issuedAt.getTime() + expireTime * 1000);
            JWTCreator.Builder jwtBuilder = JWT.create()
                                               .withIssuer("auth0") // 发行人
                                               .withIssuedAt(issuedAt) // 开始时间
                                               .withExpiresAt(expireAt); // 过期时间
            for(Map.Entry<String, Object> claim: claims.entrySet()) {
                jwtBuilder.withClaim(claim.getKey(), claim.getValue().toString()); // 存放自定义数据
            }
            token = jwtBuilder.sign(Algorithm.HMAC256(tokenSecret)); // 加密
        } catch (IllegalArgumentException | JWTCreationException je) {
            System.err.println(je);
        }
        return token;
    }



    public static Boolean checkToken(String token) {
        try {
            // 建立token验证器
            JWTVerifier jwtVerifier = JWT.require(Algorithm.HMAC256(tokenSecret)).withIssuer("auth0").build();
            DecodedJWT decodedJWT = jwtVerifier.verify(token);
        } catch (IllegalArgumentException | JWTVerificationException je) {
            return false;
        }
        return true;
    }

    public static String getClaim(String token, String key) {
        String claim = null;
        try {
            DecodedJWT decodedJWT = JWT.decode(token);
            claim = decodedJWT.getClaim(key).asString();
        } catch (JWTDecodeException je) {
            return null;
        }
        return claim;
    }
}
