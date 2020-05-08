package top.keyon.edu.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.util.StringUtils;
import top.keyon.edu.entity.Teacher;
import top.keyon.edu.entity.TeacherRequestModel;
import top.keyon.edu.mapper.TeacherMapper;
import top.keyon.edu.service.TeacherService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * <p>
 * 讲师 服务实现类
 * </p>
 *
 * @author tongkeyon
 * @since 2020-05-08
 */
@Service
public class TeacherServiceImpl extends ServiceImpl<TeacherMapper, Teacher> implements TeacherService {
    @Override
    public IPage<Teacher> selectTeacherPageCondition(Page<Teacher> teacherPage, TeacherRequestModel teacherRequestModel) {
        QueryWrapper<Teacher> queryWrapper = new QueryWrapper<>();
          if (teacherRequestModel ==null){
             return   baseMapper.selectPage(teacherPage,null);
          }

        String name = teacherRequestModel.getName();
        Integer level = teacherRequestModel.getLevel();
        String begin = teacherRequestModel.getBegin();
        String end = teacherRequestModel.getEnd();

        if (!StringUtils.isEmpty(name)){
            queryWrapper.like("name",name);
        }

        if (!StringUtils.isEmpty(level)){
            queryWrapper.eq("level",level);
        }

        if (!StringUtils.isEmpty(begin)){
            queryWrapper.ge("gmt_create",begin);
        }

        if (!StringUtils.isEmpty(end)){
            queryWrapper.le("gmt_create",begin);
        }


        return this.baseMapper.selectPage(teacherPage,queryWrapper);
    }
}
