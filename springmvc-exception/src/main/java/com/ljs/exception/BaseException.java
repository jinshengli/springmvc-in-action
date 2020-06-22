package com.ljs.exception;

/**
 * create by ljs on 2020/6/22 7:08
 * <p>
 * description:
 */
public class BaseException extends RuntimeException {


    public BaseException() {
    }

    public BaseException(String message) {
        super(message);
    }
}
