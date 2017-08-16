package com.sidgs.odp.api.error;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created by kalya on 5/28/2017.
 */
@ResponseStatus(value= HttpStatus.UNAUTHORIZED)
public class UserLoginException extends Exception {
    String errorMessage;
    String errorCode;

    public UserLoginException(String errorMessage, String errorCode) {
        this.errorMessage = errorMessage;
        this.errorCode = errorCode;
    }

    public UserLoginException(String message, String errorMessage, String errorCode) {
        super(message);
        this.errorMessage = errorMessage;
        this.errorCode = errorCode;
    }

    public UserLoginException(String message, Throwable cause, String errorMessage, String errorCode) {
        super(message, cause);
        this.errorMessage = errorMessage;
        this.errorCode = errorCode;
    }

    public UserLoginException(String errorMessage) {
        super();
        this.errorMessage = errorMessage;
        this.errorCode = errorCode;
    }

    public UserLoginException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace, String errorMessage, String errorCode) {
        super(message, cause, enableSuppression, writableStackTrace);
        this.errorMessage = errorMessage;
        this.errorCode = errorCode;
    }
}
