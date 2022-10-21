package com.tenpo.challenge.api.services;

import com.tenpo.challenge.api.exceptions.ValidationException;
import com.tenpo.challenge.api.models.domain.User;
import com.tenpo.challenge.api.models.dtos.UserRequestDto;
import com.tenpo.challenge.api.models.dtos.UserResponseDto;
import com.tenpo.challenge.api.models.persistence.UserPersistence;
import com.tenpo.challenge.api.repositories.UsersPersistenceRepository;
import com.tenpo.challenge.api.statics.ErrorCode;
import com.tenpo.challenge.api.translators.UsersTranslator;
import com.tenpo.challenge.api.utils.EncryptUtil;
import com.tenpo.challenge.api.utils.JwtUtil;
import com.tenpo.challenge.api.validators.UserValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UsersPersistenceRepository usersPersistenceRepository;

    @Autowired
    private UsersTranslator usersTranslator;

    @Autowired
    private UserValidator userValidator;

    @Autowired
    private JwtUtil jwtUtil;

    public UserResponseDto createUser(UserRequestDto userRequestDto) throws ValidationException {
        userValidator.validateCreateUserRequestDto(userRequestDto);
        if (usersPersistenceRepository.findByEmail(userRequestDto.getEmail()).isPresent()) {
            throw new ValidationException(ErrorCode.REPEAT_EMAIL);
        }

        User user = usersTranslator.toDomain(userRequestDto)
                .toBuilder()
                .lastTokenApi(jwtUtil.createApiToken(userRequestDto.getEmail()))
                .build();

        return usersTranslator.toResponse(usersPersistenceRepository.save(usersTranslator.toPersistence(user)));
    }

    public UserResponseDto login(UserRequestDto request) throws ValidationException {
        userValidator.validateLoginRequestDto(request);
        Optional<UserPersistence> userSaved = usersPersistenceRepository.findByEmail(request.getEmail());
        if (!userSaved.isPresent() || !EncryptUtil.checkHash(request.getEmail(), request.getPassword(), userSaved.get().getHashPassword())) {
            throw new ValidationException(ErrorCode.COMBINATION_FAIL);
        }

        if (jwtUtil.validate(userSaved.get().getLastTokenApi())) {
            return usersTranslator.toResponse(userSaved.get());
        }

        return usersTranslator.toResponse(userSaved.get().toBuilder().lastTokenApi(jwtUtil.createApiToken(request.getEmail())).build());
    }
}
