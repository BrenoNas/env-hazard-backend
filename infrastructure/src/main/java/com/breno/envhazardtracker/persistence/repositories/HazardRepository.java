package com.breno.envhazardtracker.persistence.repositories;

import com.breno.envhazardtracker.persistence.entities.HazardEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HazardRepository extends JpaRepository<HazardEntity, String> {

}
