package com.breno.envhazardtracker.configuration;

import com.breno.envhazardtracker.delivery.converters.HazardRestConverter;
import com.breno.envhazardtracker.hazard.usecases.ReportHazardUseCase;
import com.breno.envhazardtracker.hazard.usecases.ReportHazardUseCaseImpl;
import com.breno.envhazardtracker.persistence.converters.HazardRepositoryConverter;
import com.breno.envhazardtracker.persistence.impl.HazardServiceImpl;
import com.breno.envhazardtracker.persistence.repositories.HazardRepository;
import com.breno.envhazardtracker.persistence.repositories.HazardTypeRepository;
import com.breno.envhazardtracker.persistence.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class HazardConfiguration {

    @Autowired
    private HazardRepository hazardRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private HazardTypeRepository hazardTypeRepository;

    @Bean
    public HazardRepositoryConverter createHazardRepositoryConverter() {
        return new HazardRepositoryConverter(userRepository, hazardTypeRepository);
    }

    @Bean
    public HazardRestConverter createHazardRestConverter() {
        return new HazardRestConverter();
    }

    @Bean
    public HazardServiceImpl createHazardServiceImpl() {
        return new HazardServiceImpl(createHazardRepositoryConverter(), hazardRepository);
    }

    @Bean
    public ReportHazardUseCase createReportHazardUseCase() {
        return new ReportHazardUseCaseImpl(createHazardServiceImpl());
    }

}
