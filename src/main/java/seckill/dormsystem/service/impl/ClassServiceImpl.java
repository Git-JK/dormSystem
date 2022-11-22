package seckill.dormsystem.service.impl;

import seckill.dormsystem.domain.entity.Class;
import seckill.dormsystem.dao.ClassMapper;
import seckill.dormsystem.service.IClassService;
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
public class ClassServiceImpl extends ServiceImpl<ClassMapper, Class> implements IClassService {

}
