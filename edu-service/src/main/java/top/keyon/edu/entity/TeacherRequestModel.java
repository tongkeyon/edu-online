package top.keyon.edu.entity;

import lombok.Data;

import java.util.Date;

/**
 * @author: tongkeyon@163.com
 * @description:
 **/
@Data
public class TeacherRequestModel {



    /**
     *  TODO 用于接收前端数据的对象所有的数据类型都为String类型，
     */
    private String name;
    private Integer level;
    private String begin;
    private String end;
}
