package com.tenpo.challenge.api.validators;

import com.tenpo.challenge.api.exceptions.ValidationException;
import com.tenpo.challenge.api.statics.ErrorCode;

public class CalculateValidator extends Validators {

    public static void validateValues(Double valueA, Double valueB) throws ValidationException {
        String propertiesFailMessage = "";
        if (valueA == null) {
            propertiesFailMessage += missingFieldDescription("valueA");
        }

        if (valueB == null) {
            propertiesFailMessage += missingFieldDescription("valueB");
        }

        if (propertiesFailMessage.length() > 0) {
            throw new ValidationException(ErrorCode.INVALID_DATA, propertiesFailMessage);
        }
    }
}
