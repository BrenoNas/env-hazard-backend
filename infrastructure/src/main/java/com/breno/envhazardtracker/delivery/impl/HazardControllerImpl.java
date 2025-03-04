package com.breno.envhazardtracker.delivery.impl;

import com.breno.envhazardtracker.delivery.HazardController;
import com.breno.envhazardtracker.delivery.converters.HazardRestConverter;
import com.breno.envhazardtracker.delivery.converters.MediaRestConverter;
import com.breno.envhazardtracker.delivery.responses.EnvHazardResponse;
import com.breno.envhazardtracker.delivery.rest.HazardRest;
import com.breno.envhazardtracker.delivery.rest.MediaRest;
import com.breno.envhazardtracker.hazard.Hazard;
import com.breno.envhazardtracker.hazard.usecases.ReportHazardUseCase;
import com.breno.envhazardtracker.hazardmedia.HazardMedia;
import com.breno.envhazardtracker.hazardmedia.usecases.CreateHazardMediaRegisterUseCase;
import com.breno.envhazardtracker.media.Media;
import com.breno.envhazardtracker.media.usecases.StoreMediaUseCase;
import com.breno.envhazardtracker.shared.constants.CommonConstants;
import com.breno.envhazardtracker.shared.constants.RestConstants;
import com.breno.envhazardtracker.shared.exceptions.EnvHazardException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(RestConstants.APPLICATION_NAME + RestConstants.API_VERSION_1 + RestConstants.RESOURCE_HAZARD)
@RequiredArgsConstructor
public class HazardControllerImpl implements HazardController {

    private final ReportHazardUseCase reportHazardUseCase;

    private final HazardRestConverter hazardRestConverter;

    private final StoreMediaUseCase storeMediaUseCase;

    private final MediaRestConverter mediaRestConverter;

    private final CreateHazardMediaRegisterUseCase createHazardMediaRegisterUseCase;

    @Override
    @PostMapping(value="/create", consumes = "multipart/form-data")
    public EnvHazardResponse<Boolean> createHazard(@ModelAttribute HazardRest hazard, @ModelAttribute MediaRest media) throws EnvHazardException {
        try {
            Hazard hazardEntity = hazardRestConverter.mapToEntity(hazard);
            reportHazardUseCase.execute(hazardEntity);
            Media mediaEntity = mediaRestConverter.mapToEntity(media);
            storeMediaUseCase.execute(mediaEntity);
            HazardMedia hazardMedia = new HazardMedia(hazardEntity, mediaEntity);
            createHazardMediaRegisterUseCase.execute(hazardMedia);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return new EnvHazardResponse<Boolean>(CommonConstants.SUCCESS, String.valueOf(HttpStatus.OK), CommonConstants.OK, true);
    }
}
