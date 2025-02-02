package com.breno.envhazardtracker.hazard.usecases;

import com.breno.envhazardtracker.hazard.Hazard;
import com.breno.envhazardtracker.hazard.exceptions.HazardAlreadyExistException;

public interface ReportHazardUseCase {

    public void execute(Hazard hazard) throws HazardAlreadyExistException;

}
