package com.breno.envhazardtracker.persistence.repositories;

import com.breno.envhazardtracker.persistence.entities.HazardEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface HazardRepository extends JpaRepository<HazardEntity, UUID> {

}
