package com.breno.envhazardtracker.persistence.impl;

import com.breno.envhazardtracker.media.Media;
import com.breno.envhazardtracker.media.ports.MediaRepositoryService;
import com.breno.envhazardtracker.persistence.converters.MediaRepositoryConverter;
import com.breno.envhazardtracker.persistence.repositories.MediaRepository;
import lombok.AllArgsConstructor;

import java.util.UUID;

@AllArgsConstructor

public class MediaServiceImpl implements MediaRepositoryService {

    private final MediaRepository mediaRepository;
    private final MediaRepositoryConverter mediaRepositoryConverter;

    @Override
    public UUID SaveMedia(Media media) {
        return mediaRepository.save(mediaRepositoryConverter.mapToTable(media)).getId();
    }
}
