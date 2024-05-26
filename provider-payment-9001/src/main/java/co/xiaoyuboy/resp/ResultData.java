package co.xiaoyuboy.resp;

import io.swagger.v3.oas.annotations.media.Schema;
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
@Schema(title = "统一返回实体")
public class ResultData<T> {
    @Schema(title = "结果状态")
    private String code;/** 结果状态 ,具体状态码参见枚举类ReturnCodeEnum.java*/
    @Schema(title = "描述")
    private String message;
    @Schema(title = "本地返回的数据")
    private T data;
    @Schema(title = "时间戳")
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

