package com.sidgs.odp.api.error;

import com.sidgs.odp.error.BaseException;

/**
 * Created by kalya on 5/19/2017.
 */
public class LoginDetailsConflictException extends BaseException {

    public LoginDetailsConflictException(String errorCode, String errorDescription) {
        super(errorCode, errorDescription);
    }

    public LoginDetailsConflictException(String message, String errorCode, String errorDescription) {
        super(message, errorCode, errorDescription);
    }

    public LoginDetailsConflictException(String message, Throwable cause, String errorCode, String errorDescription) {
        super(message, cause, errorCode, errorDescription);
    }

    public LoginDetailsConflictException(Throwable cause, String errorCode, String errorDescription) {
        super(cause, errorCode, errorDescription);
    }
}
