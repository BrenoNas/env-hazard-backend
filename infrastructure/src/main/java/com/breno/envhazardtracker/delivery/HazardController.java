package com.breno.envhazardtracker.delivery;

import com.breno.envhazardtracker.delivery.responses.EnvHazardResponse;
import com.breno.envhazardtracker.delivery.rest.HazardRest;
import com.breno.envhazardtracker.shared.exceptions.EnvHazardException;

public interface HazardController {
    EnvHazardResponse<Boolean> createHazard(HazardRest hazard) throws EnvHazardException;
}
