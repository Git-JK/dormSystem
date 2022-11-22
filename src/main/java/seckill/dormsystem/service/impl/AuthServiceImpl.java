package seckill.dormsystem.service.impl;

import seckill.dormsystem.domain.entity.Auth;
import seckill.dormsystem.dao.AuthMapper;
import seckill.dormsystem.service.IAuthService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

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

}
