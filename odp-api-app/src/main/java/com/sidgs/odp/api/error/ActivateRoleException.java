package com.sidgs.odp.api.error;

/**
 * Created by kalya on 5/16/2017.
 */
public class ActivateRoleException extends RoleException {

    String errorCode;
    String errMessage;


    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrMessage() {
        return errMessage;
    }

    public void setErrMessage(String errMessage) {
        this.errMessage = errMessage;
    }

    public ActivateRoleException(String message) {
        super(message);
    }

    public ActivateRoleException(Throwable cause) {
        super(cause);
    }

    public ActivateRoleException(String errmessage, String code, Throwable cause) {
        super(errmessage, code, cause);
    }

    public ActivateRoleException(String message, Throwable cause) {
        super(message, cause);
    }

}
