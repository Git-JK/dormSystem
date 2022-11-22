package seckill.dormsystem.service.impl;

import seckill.dormsystem.domain.entity.StudentInfo;
import seckill.dormsystem.dao.StudentInfoMapper;
import seckill.dormsystem.service.IStudentInfoService;
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
public class StudentInfoServiceImpl extends ServiceImpl<StudentInfoMapper, StudentInfo> implements IStudentInfoService {

}
