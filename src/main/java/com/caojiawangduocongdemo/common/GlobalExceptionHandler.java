package com.caojiawangduocongdemo.common;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * /全局异常处理类
 * @author caojia
 * @createtime 2019-11-15 11:53
 */
@ControllerAdvice
public class GlobalExceptionHandler {
    private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    /**
     * 处理自定义异常
     * @param request
     * @param b
     * @return
     */
    @ExceptionHandler(value=BizException.class)
    @ResponseBody
    public ResultBody bizExceptionHandler(HttpServletRequest request,BizException b){
        logger.error("发生业务异常",b.getMessage());
        return ResultBody.error(b.getErrorCode(),b.getErrorMsg());
    }

    /**
     * 处理空指针异常
     * @param request
     * @param n
     * @return
     */
    @ExceptionHandler(value = NullPointerException.class)
    @ResponseBody
    public ResultBody exceptionHandler(HttpServletRequest request,NullPointerException n){
        logger.error("发生空指针异常",n.getMessage());
        return ResultBody.error(CommonEnum.BODY_NOT_MATCH);
    }

    /**
     * 其他异常
     * @param req
     * @param e
     * @return
     */
    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public ResultBody exceptionHandler(HttpServletRequest req,Exception e){
        logger.error("未知异常",e);
        return ResultBody.error(CommonEnum.INTERNAL_SERVER_ERROR);
    }
}
