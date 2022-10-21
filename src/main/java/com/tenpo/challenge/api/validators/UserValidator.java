package com.tenpo.challenge.api.validators;

import com.tenpo.challenge.api.exceptions.ValidationException;
import com.tenpo.challenge.api.models.dtos.UserRequestDto;
import com.tenpo.challenge.api.statics.ErrorCode;
import io.micrometer.common.util.StringUtils;

public class UserValidator {
    public static void validateCreateUserRequestDto(UserRequestDto request) throws ValidationException {

        String propertiesFailMessage = "";

        if (StringUtils.isEmpty(request.getName())) {
            propertiesFailMessage += missingFieldDescription("name");
        }

        if (StringUtils.isEmpty(request.getEmail())) {
            propertiesFailMessage += missingFieldDescription("email");
        }

        if (StringUtils.isEmpty(request.getPassword())) {
            propertiesFailMessage += missingFieldDescription("password");
        }


        if (StringUtils.isNotEmpty(propertiesFailMessage)) {
            String exceptionMessage = propertiesFailMessage.substring(0, propertiesFailMessage.length() - 2);
            throw new ValidationException(ErrorCode.INVALID_DATA, exceptionMessage);
        }
    }

    private static String missingFieldDescription(String field) {
        return String.format("missing field: %s, ", field);
    }
}
