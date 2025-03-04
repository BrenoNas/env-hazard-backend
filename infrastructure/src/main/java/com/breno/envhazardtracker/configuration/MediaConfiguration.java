package com.breno.envhazardtracker.configuration;

import com.breno.envhazardtracker.delivery.converters.MediaRestConverter;
import com.breno.envhazardtracker.media.usecases.StoreMediaUseCaseImpl;
import com.breno.envhazardtracker.persistence.converters.MediaRepositoryConverter;
import com.breno.envhazardtracker.persistence.impl.MediaServiceImpl;
import com.breno.envhazardtracker.persistence.impl.StorageServiceImpl;
import com.breno.envhazardtracker.persistence.repositories.MediaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import(AWSConfig.class)
public class MediaConfiguration {

    @Autowired
    private MediaRepository mediaRepository;

    @Autowired
    private AWSConfig awsConfig;

    @Bean
    public MediaRepositoryConverter createMediaRepositoryConverter() {
        return new MediaRepositoryConverter();
    }

    @Bean
    public MediaRestConverter createMediaRestConverter() {
        return new MediaRestConverter();
    }

    @Bean
    public StorageServiceImpl createStorageService() {
        return new StorageServiceImpl(awsConfig.createS3Instance());
    }

    @Bean
    public MediaServiceImpl createMediaService() {
        return new MediaServiceImpl(mediaRepository, createMediaRepositoryConverter());
    }

    @Bean
    public StoreMediaUseCaseImpl createStoreMediaUseCase() {
        return new StoreMediaUseCaseImpl(createStorageService(), createMediaService());
    }
}
