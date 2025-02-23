package com.breno.envhazardtracker.persistence.repositories;
import com.breno.envhazardtracker.persistence.entities.HazardTypeEntity;
import org.springframework.data.jpa.repository.JpaRepository;


public interface HazardTypeRepository extends JpaRepository<HazardTypeEntity, Integer> {
}
