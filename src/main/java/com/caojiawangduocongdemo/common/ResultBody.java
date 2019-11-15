/**
 * Copyright (c) 2019, 万维公司 All rights reserved.
 * 万维公司 专有/保密源代码,未经许可禁止任何人通过任何渠道使用、修改源代码.
 */
package com.caojiawangduocongdemo.common;

import com.alibaba.fastjson.JSONObject;

/**
 * 自定义数据格式
 * @author caojia
 * @createtime 2019-11-15 11:36
 */
public class ResultBody {
    //响应码
    private String code;
    //响应信息
    private String message;
    //响应数据
    private Object data;

    public ResultBody(){}

    public ResultBody(BaseErrorInfo baseErrorInfo){
        this.code = baseErrorInfo.getResultCode();
        this.message = baseErrorInfo.getResultMsg();
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    /**
     * 成功
     * @param data
     * @return
     */
    public static ResultBody success(Object data){
        ResultBody rs = new ResultBody();
        rs.setCode(CommonEnum.SUCCESS.getResultCode());
        rs.setMessage(CommonEnum.SUCCESS.getResultMsg());
        rs.setData(data);
        return rs;
    }

    /**
     * 失败
     */
    public static ResultBody error(BaseErrorInfo errorInfo) {
        ResultBody rb = new ResultBody();
        rb.setCode(errorInfo.getResultCode());
        rb.setMessage(errorInfo.getResultMsg());
        rb.setData(null);
        return rb;
    }

    /**
     * 失败
     */
    public static ResultBody error(String code, String message) {
        ResultBody rb = new ResultBody();
        rb.setCode(code);
        rb.setMessage(message);
        rb.setData(null);
        return rb;
    }

    /**
     * 失败
     */
    public static ResultBody error( String message) {
        ResultBody rb = new ResultBody();
        rb.setCode("-1");
        rb.setMessage(message);
        rb.setData(null);
        return rb;
    }

    @Override
    public String toString() {
        return JSONObject.toJSONString(this);
    }
}
