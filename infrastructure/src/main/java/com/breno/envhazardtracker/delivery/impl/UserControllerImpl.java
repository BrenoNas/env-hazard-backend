package com.breno.envhazardtracker.delivery.impl;

import com.breno.envhazardtracker.delivery.UserController;
import com.breno.envhazardtracker.delivery.converters.UserRestConverter;
import com.breno.envhazardtracker.delivery.responses.EnvHazardResponse;
import com.breno.envhazardtracker.delivery.rest.UserRest;
import com.breno.envhazardtracker.shared.constants.CommonConstants;
import com.breno.envhazardtracker.shared.constants.RestConstants;
import com.breno.envhazardtracker.shared.exceptions.EnvHazardException;
import com.breno.envhazardtracker.user.exceptions.UserAlreadyExistException;
import com.breno.envhazardtracker.user.usecases.CreateUserUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(RestConstants.APPLICATION_NAME + RestConstants.API_VERSION_1 + RestConstants.RESOURCE_AUTH)
@RequiredArgsConstructor
public class UserControllerImpl implements UserController {

    private final CreateUserUseCase createUserUseCase;

    private final UserRestConverter userRestConverter;

    @Override
    @PostMapping(value="/create")
    public EnvHazardResponse<Boolean> createUser(@RequestBody final UserRest user) throws EnvHazardException {
        try {
            createUserUseCase.execute(userRestConverter.mapToEntity(user));
        } catch (UserAlreadyExistException ex) {
            ex.printStackTrace();
        }
        return new EnvHazardResponse<>(CommonConstants.SUCCESS, String.valueOf(HttpStatus.OK), CommonConstants.OK);
    }
}
