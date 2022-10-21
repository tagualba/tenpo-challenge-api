package com.tenpo.challenge.api.repositories;

import com.tenpo.challenge.api.models.persistence.UserPersistence;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsersPersistenceRepository extends JpaRepository<UserPersistence, Long> {
    Optional<UserPersistence> findByEmail(String email);
}
