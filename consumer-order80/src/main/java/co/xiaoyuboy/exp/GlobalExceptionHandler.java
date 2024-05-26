package co.xiaoyuboy.exp;

import co.xiaoyuboy.resp.ResultData;
import co.xiaoyuboy.resp.ReturnCodeEnum;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @Author: Smile
 * @Date: 2024-05-26 09:50
 * @Description: 全局异常处理
 */
@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(RuntimeException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ResultData<String> exception(Exception e){
        log.error("全局异常信息exception:{}",e.getMessage());
        return ResultData.fail(ReturnCodeEnum.RC500.getCode(), e.getMessage());
    }
}
