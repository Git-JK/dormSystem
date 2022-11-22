package seckill.dormsystem.service.impl;

import seckill.dormsystem.domain.entity.Groups;
import seckill.dormsystem.dao.GroupsMapper;
import seckill.dormsystem.service.IGroupsService;
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
public class GroupsServiceImpl extends ServiceImpl<GroupsMapper, Groups> implements IGroupsService {

}
