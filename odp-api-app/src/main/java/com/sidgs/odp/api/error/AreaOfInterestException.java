package com.sidgs.odp.api.error;

import com.sidgs.odp.error.BaseException;

/**
 * Created by ayeluri on 5/10/2017.
 */
public class AreaOfInterestException extends BaseException {

    public AreaOfInterestException(String errorCode, String errorDescription) {
        super(errorCode, errorDescription);
    }

    public AreaOfInterestException(String message, String errorCode, String errorDescription) {
        super(message, errorCode, errorDescription);
    }

    public AreaOfInterestException(String message, Throwable cause, String errorCode, String errorDescription) {
        super(message, cause, errorCode, errorDescription);
    }

    public AreaOfInterestException(Throwable cause, String errorCode, String errorDescription) {
        super(cause, errorCode, errorDescription);
    }
}
