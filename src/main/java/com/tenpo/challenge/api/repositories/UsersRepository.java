package com.tenpo.challenge.api.repositories;

import com.tenpo.challenge.api.models.persistence.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsersRepository extends JpaRepository<Users, Long> {
}
