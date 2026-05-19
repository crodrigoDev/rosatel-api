package com.rosatel.api.dtos.Api;

import java.time.LocalDateTime;

import lombok.Builder;

@Builder
public record ErrorDTO(
    Boolean success,
    String message,
    LocalDateTime timestamp
) {
    
}
