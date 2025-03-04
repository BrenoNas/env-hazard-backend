package com.breno.envhazardtracker.persistence.repositories;

import com.breno.envhazardtracker.persistence.entities.HazardMediaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface HazardMediaRepository extends JpaRepository<HazardMediaEntity, UUID> {

}
