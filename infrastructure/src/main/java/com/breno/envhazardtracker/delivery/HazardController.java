package com.breno.envhazardtracker.delivery;

import com.breno.envhazardtracker.delivery.responses.EnvHazardResponse;
import com.breno.envhazardtracker.delivery.rest.HazardRest;
import com.breno.envhazardtracker.delivery.rest.MediaRest;
import com.breno.envhazardtracker.shared.exceptions.EnvHazardException;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;

public interface HazardController {
    EnvHazardResponse<Boolean> createHazard(@ModelAttribute HazardRest hazard, @ModelAttribute MediaRest media) throws EnvHazardException;
}
