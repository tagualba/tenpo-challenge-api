package com.tenpo.challenge.api.translators;

import com.tenpo.challenge.api.models.domain.User;
import com.tenpo.challenge.api.models.dtos.UserRequestDto;
import com.tenpo.challenge.api.models.dtos.UserResponseDto;
import com.tenpo.challenge.api.models.persistence.Users;
import com.tenpo.challenge.api.utils.EncryptUtil;
import org.springframework.stereotype.Component;

@Component
public class UsersTranslator {

    public User toDomain(UserRequestDto requestDto){
        return User.builder()
                .name(requestDto.getName())
                .email(requestDto.getEmail())
                .hashPassword(EncryptUtil.createHash(requestDto.getEmail(), requestDto.getPassword()))
                .build();
    }

    public Users toPersistence(User user){
        return Users.builder()
                .name(user.getName())
                .email(user.getEmail())
                .hashPassword(user.getHashPassword())
                .lastTokenApi(user.getLastTokenApi())
                .build();
    }

    public User toDomain(Users usersPersistence){
        return User.builder()
                .name(usersPersistence.getName())
                .email(usersPersistence.getEmail())
                .hashPassword(usersPersistence.getHashPassword())
                .lastTokenApi(usersPersistence.getLastTokenApi())
                .build();
    }

    public UserResponseDto toResponse(User user){
        return UserResponseDto.builder()
                .id(user.getId())
                .tokenApiKey(user.getLastTokenApi())
                .build();
    }

}
