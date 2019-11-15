package com.caojiawangduocongdemo.common;

/**
 * 自定义错误描述
 */
public interface BaseErrorInfo {
    //获取错误码
    String getResultCode();
    //获取错误信息
    String getResultMsg();
}
