package com.breno.envhazardtracker.persistence.repositories;

import com.breno.envhazardtracker.persistence.entities.MediaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface MediaRepository extends JpaRepository<MediaEntity, UUID> {

}
