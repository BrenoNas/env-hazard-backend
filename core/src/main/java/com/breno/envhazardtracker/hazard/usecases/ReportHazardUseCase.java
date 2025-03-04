package com.breno.envhazardtracker.hazard.usecases;

import com.breno.envhazardtracker.hazard.Hazard;
import com.breno.envhazardtracker.hazard.exceptions.HazardAlreadyExistException;

import java.util.UUID;

public interface ReportHazardUseCase {

    public UUID execute(Hazard hazard) throws HazardAlreadyExistException;

}
