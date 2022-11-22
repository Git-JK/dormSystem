package seckill.dormsystem.service.impl;

import seckill.dormsystem.domain.entity.Buildings;
import seckill.dormsystem.dao.BuildingsMapper;
import seckill.dormsystem.service.IBuildingsService;
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
public class BuildingsServiceImpl extends ServiceImpl<BuildingsMapper, Buildings> implements IBuildingsService {

}
