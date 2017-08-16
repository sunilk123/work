package com.sidgs.odp.api.error;

import com.sidgs.odp.error.BaseException;

/**
 * Created by ayeluri on 5/28/2017.
 */
public class UserAlreadyPresentException extends BaseException {
    public UserAlreadyPresentException(String errorCode, String errorDescription) {
        super(errorCode, errorDescription);
    }

    public UserAlreadyPresentException(String message, String errorCode, String errorDescription) {
        super(message, errorCode, errorDescription);
    }

    public UserAlreadyPresentException(String message, Throwable cause, String errorCode, String errorDescription) {
        super(message, cause, errorCode, errorDescription);
    }

    public UserAlreadyPresentException(Throwable cause, String errorCode, String errorDescription) {
        super(cause, errorCode, errorDescription);
    }

    public UserAlreadyPresentException() {
        super("", "");
    }
}
