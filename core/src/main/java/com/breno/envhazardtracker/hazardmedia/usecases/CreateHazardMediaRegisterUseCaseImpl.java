package com.breno.envhazardtracker.hazardmedia.usecases;

import com.breno.envhazardtracker.hazardmedia.HazardMedia;
import com.breno.envhazardtracker.hazardmedia.ports.HazardMediaRepositoryService;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class CreateHazardMediaRegisterUseCaseImpl implements CreateHazardMediaRegisterUseCase {

    private HazardMediaRepositoryService hazardMediaRepositoryService;

    @Override
    public void execute(HazardMedia hazardMedia) {
        hazardMediaRepositoryService.SaveHazardMedia(hazardMedia);
    }
}
