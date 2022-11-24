package seckill.dormsystem.service;

import seckill.dormsystem.domain.dto.LoginDto;
import seckill.dormsystem.domain.entity.Auth;
import com.baomidou.mybatisplus.extension.service.IService;
import seckill.dormsystem.exception.ServiceException;

import javax.servlet.http.HttpServletRequest;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author kk
 * @since 2022-11-22
 */
public interface IAuthService extends IService<Auth> {
    /**
     * 用户登录服务
     * @param loginDto
     * @return 用户登录信息
     */
    Auth login(LoginDto loginDto) throws ServiceException;

    void logout(String token) throws ServiceException;
}
