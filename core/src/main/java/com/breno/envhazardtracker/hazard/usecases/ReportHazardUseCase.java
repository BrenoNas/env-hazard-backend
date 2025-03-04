package com.breno.envhazardtracker.hazard.usecases;

import com.breno.envhazardtracker.hazard.Hazard;
import com.breno.envhazardtracker.hazard.exceptions.HazardAlreadyExistException;

import java.util.UUID;

public interface ReportHazardUseCase {

    public void execute(Hazard hazard) throws HazardAlreadyExistException;

}
