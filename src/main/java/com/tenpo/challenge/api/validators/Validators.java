package com.tenpo.challenge.api.validators;

public abstract class Validators {

    public static String missingFieldDescription(String field) {
        return String.format("missing field: %s ", field);
    }

}
