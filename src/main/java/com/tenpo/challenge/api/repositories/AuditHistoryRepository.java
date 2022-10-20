package com.tenpo.challenge.api.repositories;

import com.tenpo.challenge.api.models.persistence.AuditHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuditHistoryRepository extends JpaRepository<AuditHistory, Long> {
}
