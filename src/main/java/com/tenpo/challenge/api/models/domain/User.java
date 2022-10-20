package com.tenpo.challenge.api.models.domain;

import lombok.Builder;
import lombok.Data;

@Data
@Builder(toBuilder = true)
public class User {
    private Long id;

    private String name;

    private String email;

    private String hashPassword;

    private String lastTokenApi;
}
