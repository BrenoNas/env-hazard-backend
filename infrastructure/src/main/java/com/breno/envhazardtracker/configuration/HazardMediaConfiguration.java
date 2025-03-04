package com.breno.envhazardtracker.configuration;

import com.breno.envhazardtracker.hazardmedia.usecases.CreateHazardMediaRegisterUseCaseImpl;
import com.breno.envhazardtracker.persistence.converters.HazardMediaRepositoryConverter;
import com.breno.envhazardtracker.persistence.impl.HazardMediaServiceImpl;
import com.breno.envhazardtracker.persistence.repositories.HazardMediaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import({HazardConfiguration.class, MediaConfiguration.class})
public class HazardMediaConfiguration {

    @Autowired
    private HazardMediaRepository hazardMediaRepository;

    @Autowired
    HazardConfiguration hazardConfiguration;

    @Autowired
    MediaConfiguration mediaConfiguration;

    @Bean
    public HazardMediaRepositoryConverter createMediaHazardsRepositoryConverter() {
        return new HazardMediaRepositoryConverter(hazardConfiguration.createHazardRepositoryConverter(),
                mediaConfiguration.createMediaRepositoryConverter());
    }

    @Bean
    public HazardMediaServiceImpl createHazardMediaService() {
        return new HazardMediaServiceImpl(hazardMediaRepository, createMediaHazardsRepositoryConverter());
    }

    @Bean
    public CreateHazardMediaRegisterUseCaseImpl createHazardMediaRegisterUseCase() {
        return new CreateHazardMediaRegisterUseCaseImpl(createHazardMediaService());
    }
}
