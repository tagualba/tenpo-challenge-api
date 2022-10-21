package com.tenpo.challenge.api.exceptions;

import com.tenpo.challenge.api.statics.ErrorCode;

public class ValidationException extends Exception {

    private ErrorCode validationErrorCode;

    public ValidationException(ErrorCode validationErrorCode) {
        super(validationErrorCode.getMessage());
        this.validationErrorCode = validationErrorCode;
    }

    public ValidationException(ErrorCode validationErrorCode, String message) {
        super(message);
        this.validationErrorCode = validationErrorCode;
    }

    public ValidationException(ErrorCode validationErrorCode, String message, Throwable cause) {
        super(message, cause);
        this.validationErrorCode = validationErrorCode;
    }

    public ErrorCode getValidationErrorCode() {
        return validationErrorCode;
    }
}
