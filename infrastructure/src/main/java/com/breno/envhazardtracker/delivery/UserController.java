package com.breno.envhazardtracker.delivery;

import com.breno.envhazardtracker.delivery.responses.EnvHazardResponse;
import com.breno.envhazardtracker.delivery.rest.UserRest;
import com.breno.envhazardtracker.shared.exceptions.EnvHazardException;

public interface UserController {

    EnvHazardResponse<Boolean> createUser(UserRest user) throws EnvHazardException;

}
