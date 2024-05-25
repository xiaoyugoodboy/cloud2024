package co.xiaoyuboy.resp;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @Author: Smile
 * @Date: 2024-05-25 18:37
 * @Description:
 */
//开启set链式调用
@Accessors(chain = true)
@Data
public class ResultData<T> {
    private String code;/** 结果状态 ,具体状态码参见枚举类ReturnCodeEnum.java*/
    private String message;
    private T data;
    private long timestamp;

    public ResultData() {
        this.timestamp=System.currentTimeMillis();
    }
    public static <T> ResultData<T> success(T data){
        ResultData<T> resultData = new ResultData<>();
        return resultData.setCode(ReturnCodeEnum.RC200.getCode())
                .setMessage(ReturnCodeEnum.RC200.getMessage())
                .setData(data);
    }
    public static <T> ResultData<T> fail(String code,String message){
        ResultData<T> resultData = new ResultData<>();
        return resultData.setCode(code)
                .setMessage(message)
                .setData(null);
    }
}

