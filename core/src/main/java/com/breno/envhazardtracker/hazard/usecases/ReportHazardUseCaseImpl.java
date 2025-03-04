package com.breno.envhazardtracker.hazard.usecases;

import com.breno.envhazardtracker.hazard.Hazard;
import com.breno.envhazardtracker.hazard.exceptions.HazardAlreadyExistException;
import com.breno.envhazardtracker.hazard.ports.HazardRepositoryService;

import lombok.AllArgsConstructor;

import java.util.UUID;

@AllArgsConstructor
public class ReportHazardUseCaseImpl implements ReportHazardUseCase {

    private final HazardRepositoryService hazardRepository;

    @Override
    public UUID execute(Hazard hazard) throws HazardAlreadyExistException {
        return hazardRepository.saveHazard(hazard);
    }
}
