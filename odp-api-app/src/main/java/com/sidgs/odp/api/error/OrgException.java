package com.sidgs.odp.api.error;

/**
 * Created by kalya on 6/26/2017.
 */
public class OrgException extends Exception {
    String errorMessage;
    String errorCode;

    public OrgException(){

    }

    public OrgException(String errorMessage,String errorCode) {
        this.errorCode=errorCode;
        this.errorMessage=errorMessage;
    }

    public OrgException(String message,String errorMessage,String errorCode) {
        super(message);
        this.errorCode=errorCode;
        this.errorMessage=errorMessage;
    }

    public OrgException(String message, Throwable cause,String errorCode,String errorMessage) {
        super(message, cause);
        this.errorCode=errorCode;
        this.errorMessage=errorMessage;
    }

    public OrgException(Throwable cause,String errorCode,String errorMessage) {
        super(cause);
        this.errorCode=errorCode;
        this.errorMessage=errorMessage;
    }

    protected OrgException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace,String errorCode,String errorMessage) {
        super(message, cause, enableSuppression, writableStackTrace);
        this.errorCode=errorCode;
        this.errorMessage=errorMessage;
    }
}
