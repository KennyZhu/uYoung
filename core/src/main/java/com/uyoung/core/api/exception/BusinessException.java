package com.uyoung.core.api.exception;

/**
 * Desc:
 * <p/>Date: 2015-12-08
 * <br/>Time: 15:03
 * <br/>User: ylzhu
 */
public class BusinessException extends Exception {
    public BusinessException(Object message, Exception e) {
        super(message.toString(), e);
    }

    public BusinessException(Object message) {
        super(message.toString());
    }

}
