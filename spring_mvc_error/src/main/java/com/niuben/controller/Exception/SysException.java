package com.niuben.controller.Exception;

/**
 * 自定义异常类
 */
public class SysException extends Exception {
    //存储错误信息
    private String message;

    public SysException(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }



}
