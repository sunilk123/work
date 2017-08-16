package com.sidgs.odp.api.error;

/**
 * Created by kalya on 5/10/2017.
 */
public class RoleException extends Exception{

    String userErrorMessage ;
    String userErrorCode ;

    public RoleException() {
    }

    public RoleException(String message) {
        super(message);
    }

    public RoleException(String message, Throwable cause) {
        super(message, cause);
    }

    public RoleException(Throwable cause) {
        super(cause);
    }

    public RoleException(String errmessage, String code, Throwable cause) {

        super(cause);
        userErrorMessage = errmessage ;
        userErrorCode = code;
    }



}
