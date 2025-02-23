package com.breno.envhazardtracker.delivery.impl;

import com.breno.envhazardtracker.delivery.HazardController;
import com.breno.envhazardtracker.delivery.converters.HazardRestConverter;
import com.breno.envhazardtracker.delivery.responses.EnvHazardResponse;
import com.breno.envhazardtracker.delivery.rest.HazardRest;
import com.breno.envhazardtracker.hazard.usecases.ReportHazardUseCase;
import com.breno.envhazardtracker.shared.constants.CommonConstants;
import com.breno.envhazardtracker.shared.constants.RestConstants;
import com.breno.envhazardtracker.shared.exceptions.EnvHazardException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(RestConstants.APPLICATION_NAME + RestConstants.API_VERSION_1 + RestConstants.RESOURCE_HAZARD)
@RequiredArgsConstructor
public class HazardControllerImpl implements HazardController {

    private final ReportHazardUseCase reportHazardUseCase;

    private final HazardRestConverter hazardRestConverter;

    @Override
    @PostMapping(value="/create")
    public EnvHazardResponse<Boolean> createHazard(@RequestBody final HazardRest hazard) throws EnvHazardException {
        try {
            reportHazardUseCase.execute(hazardRestConverter.mapToEntity(hazard));
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return new EnvHazardResponse<Boolean>(CommonConstants.SUCCESS, String.valueOf(HttpStatus.OK), CommonConstants.OK, true);
    }
}
