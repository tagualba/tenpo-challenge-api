package com.tenpo.challenge.api.models.persistence;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Entity
@Data
@Builder
@AllArgsConstructor
@Table(name = "audit_history")
public class AuditHistoryPersistence {
    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "user_id", updatable = false,  nullable = false)
    private Long userId;

    @Column(name = "operation", nullable = false)
    private String operation;

    @Column(name = "request", nullable = false)
    private String request;

    @Column(name = "response", nullable = false)
    private String response;

    public AuditHistoryPersistence(){
    }
}
