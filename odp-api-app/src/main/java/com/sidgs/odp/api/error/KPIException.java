package com.sidgs.odp.api.error;

import com.sidgs.odp.error.BaseException;

/**
 * Created by srika on 5/11/2017.
 */
public class KPIException extends BaseException {

    public KPIException(String errorCode, String errorDescription) {
        super(errorCode, errorDescription);
    }

    public KPIException(String message, String errorCode, String errorDescription) {
        super(message, errorCode, errorDescription);
    }

    public KPIException(String message, Throwable cause, String errorCode, String errorDescription) {
        super(message, cause, errorCode, errorDescription);
    }

    public KPIException(Throwable cause, String errorCode, String errorDescription) {
        super(cause, errorCode, errorDescription);
    }
}
