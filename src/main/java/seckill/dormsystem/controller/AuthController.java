package seckill.dormsystem.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import seckill.dormsystem.common.utils.JwtTokenUtil;
import seckill.dormsystem.domain.bo.LoginBo;
import seckill.dormsystem.domain.dto.LoginDto;
import seckill.dormsystem.domain.dto.RefreshTokenDto;
import seckill.dormsystem.domain.entity.Auth;
import seckill.dormsystem.domain.vo.LoginVo;
import seckill.dormsystem.domain.vo.RefreshTokenVo;
import seckill.dormsystem.exception.*;
import seckill.dormsystem.response.BaseResponse;
import seckill.dormsystem.response.RespGenerator;
import seckill.dormsystem.service.IAuthService;
import seckill.dormsystem.service.TokenService;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author kk
 * @since 2022-11-22
 */
@RestController
@RequestMapping("/auth")
public class AuthController {

    @Resource
    private IAuthService authService;

    @Resource
    private TokenService tokenService;

    @Value("${token.tokenType}")
    private String tokenType;

    @Value("${token.scope}")
    private String scope;
    @ExceptionHandler(ServiceException.class)
    public BaseResponse<Void> handleException(Throwable e) {
        String msg = e.getMessage();
        if (e instanceof UserNotFoundException) {
            return RespGenerator.returnError(511001, msg);
        }
        if (e instanceof PasswordNotMatchException) {
            return RespGenerator.returnError(511002, msg);
        }
        if (e instanceof LogoutException) {
            return RespGenerator.returnError(511003, msg);
        }
        if (e instanceof TokenException) {
            return RespGenerator.returnError(511004, msg);
        }
        return RespGenerator.returnError(511005, msg);
    }

    @PostMapping("login")
    public BaseResponse<LoginBo> login(@RequestBody LoginVo loginVo) throws ServiceException {
        Auth authInfo = authService.login(new LoginDto(loginVo.getUsername(), loginVo.getPassword()));
        Integer uid = authInfo.getUid();
        String uidStr = String.valueOf(uid);
        String accessToken = tokenService.generateAccessToken(uidStr);
        String refreshToken = tokenService.generateRefreshToken(uidStr);
        Long expiresIn = tokenService.getAccessExpiration();
        LoginBo loginBo = new LoginBo(accessToken, tokenType, expiresIn, scope, refreshToken);
        return RespGenerator.returnOK("用户登录成功", loginBo);
    }
    @PostMapping("logout")
    public BaseResponse<Void> logout(HttpServletRequest request) throws ServiceException {
        String token = request.getHeader("Authorization").split(" ")[1];
        authService.logout(token);
        return RespGenerator.returnOK("用户登出成功", null);
    }
    @PostMapping("refreshtoken")
    public BaseResponse<LoginBo> refreshToken(@RequestBody RefreshTokenVo refreshTokenVo) throws ServiceException{
        String refreshToken = refreshTokenVo.getRefreshToken();
        RefreshTokenDto refreshTokenDto = new RefreshTokenDto();
        refreshTokenDto.setRefreshToken(refreshToken);
        RefreshTokenDto newToken = tokenService.refreshToken(refreshTokenDto);
        Long expiresIn = tokenService.getAccessExpiration();
        LoginBo newLoginBo = new LoginBo(newToken.getAccessToken(), tokenType, expiresIn, scope, newToken.getRefreshToken());
        return RespGenerator.returnOK("刷新token成功", newLoginBo);
    }
}
