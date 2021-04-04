package com.niuben.springbootrestfulcrud.exception;

/**
 * 用户不存在异常
 */
public class UserNotFindException extends RuntimeException {
    public UserNotFindException() {
        super("用户不存在");
    }
}
