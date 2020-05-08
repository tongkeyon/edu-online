package top.keyon;

import lombok.Data;

/**
 * @author: tongkeyon@163.com
 * @description:
 **/

@Data
public class CommonResponse<T> {
    private int code;
    private String message;
    private  T data;

    public  static <T> CommonResponse succeed(T data){
        CommonResponse<T> response = new CommonResponse<>();
        response.setCode(ResponseEnum.SUCCEED.getCode());
        response.setData(data);
        response.setMessage(ResponseEnum.SUCCEED.getMsg());
        return response;
    }


    public  static <T> CommonResponse fail(ResponseEnum responseEnum){
        CommonResponse<T> response = new CommonResponse<>();
        response.setCode(responseEnum.getCode());
        response.setData(null);
        response.setMessage(responseEnum.getMsg());
        return response;
    }
}
