package com.breno.envhazardtracker.media.ports;

import com.breno.envhazardtracker.media.Media;

import java.util.UUID;

public interface MediaRepositoryService {

    public UUID SaveMedia(Media media);
}
