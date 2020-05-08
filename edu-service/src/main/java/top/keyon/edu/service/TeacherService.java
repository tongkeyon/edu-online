package top.keyon.edu.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import top.keyon.edu.entity.Teacher;
import com.baomidou.mybatisplus.extension.service.IService;
import top.keyon.edu.entity.TeacherRequestModel;

/**
 * <p>
 * 讲师 服务类
 * </p>
 *
 * @author tongkeyon
 * @since 2020-05-08
 */
public interface TeacherService extends IService<Teacher> {

    IPage<Teacher> selectTeacherPageCondition(Page<Teacher> teacherPage, TeacherRequestModel teacherRequestModel);
}
