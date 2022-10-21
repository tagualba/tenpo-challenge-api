package com.tenpo.challenge.api.services;

import com.tenpo.challenge.api.exceptions.ValidationException;
import com.tenpo.challenge.api.models.domain.User;
import com.tenpo.challenge.api.models.dtos.UserRequestDto;
import com.tenpo.challenge.api.models.dtos.UserResponseDto;
import com.tenpo.challenge.api.repositories.UsersRepository;
import com.tenpo.challenge.api.translators.UsersTranslator;
import com.tenpo.challenge.api.utils.JwtUtil;
import com.tenpo.challenge.api.validators.UserValidator;
import org.springframework.beans.factory.annotation.Autowired;

public class UserService {

    @Autowired
    private UsersRepository usersRepository;
    @Autowired
    private UsersTranslator usersTranslator;

    @Autowired
    private JwtUtil jwtUtil;

    public UserResponseDto createUser(UserRequestDto userRequestDto) throws ValidationException {
        UserValidator.validateCreateUserRequestDto(userRequestDto);
        User user = usersTranslator.toDomain(userRequestDto)
                .toBuilder()
                .lastTokenApi(jwtUtil.createApiToken(userRequestDto.getEmail()))
                .build();

        return usersTranslator.toResponse(usersRepository.save(usersTranslator.toPersistence(user)));
    }

    public UserResponseDto login(UserRequestDto request) {
        return UserResponseDto.builder().build();
    }
}
