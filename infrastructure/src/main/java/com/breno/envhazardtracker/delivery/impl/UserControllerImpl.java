package com.breno.envhazardtracker.delivery.impl;

import com.breno.envhazardtracker.delivery.UserController;
import com.breno.envhazardtracker.delivery.converters.UserRestConverter;
import com.breno.envhazardtracker.delivery.responses.EnvHazardResponse;
import com.breno.envhazardtracker.delivery.rest.UserRest;
import com.breno.envhazardtracker.persistence.entities.UserEntity;
import com.breno.envhazardtracker.security.TokenService;
import com.breno.envhazardtracker.shared.constants.CommonConstants;
import com.breno.envhazardtracker.shared.constants.RestConstants;
import com.breno.envhazardtracker.shared.exceptions.EnvHazardException;
import com.breno.envhazardtracker.user.exceptions.UserAlreadyExistException;
import com.breno.envhazardtracker.user.usecases.CreateUserUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(RestConstants.APPLICATION_NAME + RestConstants.API_VERSION_1 + RestConstants.RESOURCE_AUTH)
@RequiredArgsConstructor
public class UserControllerImpl implements UserController {

    private final CreateUserUseCase createUserUseCase;

    private final UserRestConverter userRestConverter;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private TokenService tokenService;

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

    @Override
    @PostMapping(value="/login")
    public EnvHazardResponse<String> login(@RequestBody final UserRest user) throws EnvHazardException {

        var usernamePassword = new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword());
        var auth = authenticationManager.authenticate(usernamePassword);
        var token = tokenService.generateToken((UserEntity) auth.getPrincipal());

        return new EnvHazardResponse<String>(CommonConstants.SUCCESS, String.valueOf(HttpStatus.OK), CommonConstants.OK, token);
    }
}
