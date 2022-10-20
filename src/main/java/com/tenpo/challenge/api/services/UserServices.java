package com.tenpo.challenge.api.services;

import com.tenpo.challenge.api.models.domain.User;
import com.tenpo.challenge.api.models.dtos.UserRequestDto;
import com.tenpo.challenge.api.models.dtos.UserResponseDto;
import com.tenpo.challenge.api.translators.UsersTranslator;
import org.springframework.beans.factory.annotation.Autowired;

public class UserServices {

    @Autowired
    private UsersTranslator usersTranslator;

    public UserResponseDto createUser(UserRequestDto userRequestDto){
        User.UserBuilder user = usersTranslator.toDomain(userRequestDto).toBuilder();


        return usersTranslator.toResponse(user.build());
    }
}
