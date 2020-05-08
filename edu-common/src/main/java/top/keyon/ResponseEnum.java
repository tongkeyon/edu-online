package top.keyon;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum ResponseEnum {

    SUCCEED("操作成功",200),;

    private String msg;
    private int code;


}
