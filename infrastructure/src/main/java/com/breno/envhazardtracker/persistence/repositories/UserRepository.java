package com.breno.envhazardtracker.persistence.repositories;

import com.breno.envhazardtracker.persistence.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Optional;
import java.util.UUID;

public interface UserRepository extends JpaRepository<UserEntity, UUID> {
    Optional<UserDetails> findByUsername(String username);
}
