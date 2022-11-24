package seckill.dormsystem.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import seckill.dormsystem.domain.dto.LoginDto;
import seckill.dormsystem.domain.entity.Auth;
import seckill.dormsystem.dao.AuthMapper;
import seckill.dormsystem.exception.LogoutException;
import seckill.dormsystem.exception.PasswordNotMatchException;
import seckill.dormsystem.exception.ServiceException;
import seckill.dormsystem.exception.UserNotFoundException;
import seckill.dormsystem.service.IAuthService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import seckill.dormsystem.service.RedisService;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author kk
 * @since 2022-11-22
 */
@Service
public class AuthServiceImpl extends ServiceImpl<AuthMapper, Auth> implements IAuthService {

    @Resource
    private RedisService redisService;

    @Override
    public Auth login(LoginDto loginDto) throws ServiceException {
        String username = loginDto.getUsername();
        String password = loginDto.getPassword();
        Auth authInfo = getOne(new QueryWrapper<Auth>().eq("username", username));
        // 数据库中未找到用户名
        if (authInfo == null) {
            throw new UserNotFoundException("用户名不存在");
        }
        // 输入密码错误
        if (!password.equals(authInfo.getPassword())) {
            throw new PasswordNotMatchException("用户名或密码错误");
        }
        return authInfo;
    }

    @Override
    public void logout(String token) throws ServiceException {
        if(!redisService.hasKey(token)) {
            throw new LogoutException("已处于登出状态!");
        }
        redisService.delete(token);
    }

}
