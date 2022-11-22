package seckill.dormsystem.dao;

import seckill.dormsystem.domain.entity.Orders;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author kk
 * @since 2022-11-22
 */
@Mapper
public interface OrdersMapper extends BaseMapper<Orders> {

}
