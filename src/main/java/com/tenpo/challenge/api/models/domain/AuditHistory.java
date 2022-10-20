package com.tenpo.challenge.api.models.domain;

import com.tenpo.challenge.api.statics.Operations;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AuditHistory {
    private Long id;

    private Long userid;

    private Operations operation;

    private String request;

    private String response;
}
