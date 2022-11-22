package seckill.dormsystem.service.impl;

import seckill.dormsystem.domain.entity.Users;
import seckill.dormsystem.dao.UsersMapper;
import seckill.dormsystem.service.IUsersService;
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
public class UsersServiceImpl extends ServiceImpl<UsersMapper, Users> implements IUsersService {

}
