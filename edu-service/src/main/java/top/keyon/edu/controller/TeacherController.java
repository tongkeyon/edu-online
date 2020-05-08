package top.keyon.edu.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import top.keyon.CommonResponse;
import top.keyon.edu.entity.Teacher;
import top.keyon.edu.entity.TeacherRequestModel;
import top.keyon.edu.service.TeacherService;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

/**
 * <p>
 * 讲师 前端控制器
 * </p>
 *
 * @author tongkeyon
 * @since 2020-05-08
 */
@RestController
@RequestMapping("/edu/teacher")
public class TeacherController {

    @Autowired
    private TeacherService teacherService;


    @GetMapping("/all")
    public CommonResponse getAllTeacher(){
        List<Teacher> list = teacherService.list(null);
        return CommonResponse.succeed(list);

    }

    @DeleteMapping("{id}")
    public boolean delete(@PathVariable("id") String id){
      return   teacherService.removeById(id);
    }

    @GetMapping("/list/{current}/{size}")
    public CommonResponse page(@PathVariable("current") Long current,@PathVariable("size") Long size){
        Page<Teacher> teacherPage = new Page<>(current, size);
        IPage<Teacher> page = teacherService.page(teacherPage, null);
        HashMap<String, Object> result = new HashMap<>();
        result.put("total",page.getTotal());
        result.put("records",page.getRecords());
        return  CommonResponse.succeed(result);
    }

    @GetMapping("/condition/{current}/{size}")
    public CommonResponse getByCondition(@PathVariable("current")Long current,
                                         @PathVariable("size") Long size,
                                         TeacherRequestModel teacherRequestModel){
        Page<Teacher> teacherPage = new Page<>(current, size);
        IPage<Teacher> page=teacherService.selectTeacherPageCondition(teacherPage,teacherRequestModel);
        HashMap<String, Object> result = new HashMap<>();
        result.put("total",page.getTotal());
        result.put("records",page.getRecords());
        return  CommonResponse.succeed(result);

    }

}

