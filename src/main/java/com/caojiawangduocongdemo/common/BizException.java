package com.caojiawangduocongdemo.common;

/**
 * 自定义异常
 * @author caojia
 * @createtime 2019-11-15 11:27
 */
public class BizException extends RuntimeException {
    private static final long serialVersionUID = 1L;
    private String errorCode;
    private String errorMsg;

    public BizException() {
    }
    public BizException(BaseErrorInfo baseResultInfo){
        super(baseResultInfo.getResultCode());
        this.errorCode = baseResultInfo.getResultCode();
        this.errorMsg = baseResultInfo.getResultMsg();
    }
    public BizException(BaseErrorInfo baseResultInfo,Throwable cause){
        super(baseResultInfo.getResultCode(),cause);
        this.errorCode = baseResultInfo.getResultCode();
        this.errorMsg = baseResultInfo.getResultMsg();
    }
    public BizException(String errorMsg){
        super(errorMsg);
        this.errorMsg = errorMsg;
    }

    public BizException(String errorCode,String errorMsg){
        super(errorCode);
        this.errorMsg = errorMsg;
        this.errorCode = errorCode;
    }

    public BizException(String errorCode,String errorMsg,Throwable cause){
        super(errorCode,cause);
        this.errorMsg = errorMsg;
        this.errorCode = errorCode;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    public String getMessage(){
        return errorMsg;
    }

    @Override
    public synchronized Throwable fillInStackTrace() {
        return this;
    }
}
