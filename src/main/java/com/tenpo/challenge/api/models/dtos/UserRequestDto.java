package com.tenpo.challenge.api.models.dtos;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@JsonDeserialize(builder = UserRequestDto.UserRequestDtoBuilder.class)
public class UserRequestDto {

    private String name;

    private String email;

    private String password;

}
