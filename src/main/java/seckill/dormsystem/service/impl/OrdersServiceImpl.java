package seckill.dormsystem.service.impl;

import seckill.dormsystem.domain.entity.Orders;
import seckill.dormsystem.dao.OrdersMapper;
import seckill.dormsystem.service.IOrdersService;
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
public class OrdersServiceImpl extends ServiceImpl<OrdersMapper, Orders> implements IOrdersService {

}
