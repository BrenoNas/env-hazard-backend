package com.breno.envhazardtracker.media.usecases;

import com.breno.envhazardtracker.media.Media;
import com.breno.envhazardtracker.media.exceptions.UploadMediaFailException;

import java.util.UUID;

public interface StoreMediaUseCase {
    public UUID execute(Media media) throws UploadMediaFailException;
}
