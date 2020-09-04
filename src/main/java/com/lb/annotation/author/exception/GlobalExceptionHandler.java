package com.lb.annotation.author.exception;

import com.lb.annotation.author.constant.ResultState;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Map;

/**
 * @author : lb
 * @date : 2020/9/4 10:51
 * @description :
 */
@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    /**
     * 处理RequestBody中参数类型不匹配异常
     * */
    @ExceptionHandler(HttpMessageNotReadableException.class)
    public Map<String, Object> handlerHttpMessageNotReadableException(HttpMessageNotReadableException e){
        log.error(e.getMessage(), e);
        return ResultState.FAIL.toMap();
    }

    /**
     * 处理RequestBody中参数类型不匹配异常
     * */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, Object> handlerMethodArgumentNotValidException(MethodArgumentNotValidException e){
        log.error(e.getMessage(), e);
        return ResultState.WRONG_PARAM.toMap();
    }

    /**
     * 处理全局异常
     * */
    @ExceptionHandler(Exception.class)
    public Map<String, Object> handlerException(Exception e){
        log.error(e.getMessage(), e);
        return ResultState.SYSTEM_EXCEPTION.toMap();
    }

    /**
     * 处理全局异常
     * */
    @ExceptionHandler(UserException.class)
    public Map<String, Object> handlerUserException(UserException e){
        log.error(e.getMessage(), e);
        return ResultState.USER_ERROR.toMap();
    }
}
