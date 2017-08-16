package com.sidgs.odp.api.error;

import com.sidgs.odp.error.BaseException;

/**
 * Created by ryarakaraju on 7/8/17.
 */
public class ConnectorException extends BaseException {

        public ConnectorException(String errorCode, String errorDescription) {
            super(errorCode, errorDescription);
        }

        public ConnectorException(String message, String errorCode, String errorDescription) {
            super(message, errorCode, errorDescription);
        }

        public ConnectorException(String message, Throwable cause, String errorCode, String errorDescription) {
            super(message, cause, errorCode, errorDescription);
        }

        public ConnectorException(Throwable cause, String errorCode, String errorDescription) {
            super(cause, errorCode, errorDescription);
        }
    }