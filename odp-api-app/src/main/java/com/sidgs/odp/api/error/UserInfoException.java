package com.sidgs.odp.api.error;

/**
 * Created by kalya on 5/28/2017.
 */
public class UserInfoException extends Exception {
    String errorMessage;
    String errorCode;

    public UserInfoException(String errorMessage, String errorCode) {
        this.errorMessage = errorMessage;
        this.errorCode = errorCode;
    }

    public UserInfoException(String message, String errorMessage, String errorCode) {
        super(message);
        this.errorMessage = errorMessage;
        this.errorCode = errorCode;
    }

    public UserInfoException(String message, Throwable cause, String errorMessage, String errorCode) {
        super(message, cause);
        this.errorMessage = errorMessage;
        this.errorCode = errorCode;
    }

    public UserInfoException(String errorMessage) {
        super();
        this.errorMessage = errorMessage;
        this.errorCode = errorCode;
    }

    public UserInfoException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace, String errorMessage, String errorCode) {
        super(message, cause, enableSuppression, writableStackTrace);
        this.errorMessage = errorMessage;
        this.errorCode = errorCode;
    }
}
