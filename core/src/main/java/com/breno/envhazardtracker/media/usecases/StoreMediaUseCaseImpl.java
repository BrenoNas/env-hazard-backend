package com.breno.envhazardtracker.media.usecases;

import com.breno.envhazardtracker.media.Media;
import com.breno.envhazardtracker.media.exceptions.UploadMediaFailException;
import com.breno.envhazardtracker.media.ports.StorageService;
import com.breno.envhazardtracker.media.ports.MediaRepositoryService;
import lombok.AllArgsConstructor;

import java.util.UUID;

@AllArgsConstructor
public class StoreMediaUseCaseImpl implements StoreMediaUseCase {

    final StorageService storageService;
    final MediaRepositoryService mediaRepositoryService;

    @Override
    public UUID execute(Media media) throws UploadMediaFailException {
        String url = storageService.uploadFile(media.getContent(), media.getFileName());
        if (url.isEmpty())
        {
            throw new UploadMediaFailException();
        }
        media.setUrl(url);
        return mediaRepositoryService.SaveMedia(media);
    }
}
