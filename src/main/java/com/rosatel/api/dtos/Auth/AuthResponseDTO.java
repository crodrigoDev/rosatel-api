package com.rosatel.api.dtos.Auth;

import lombok.Builder;

@Builder
public record AuthResponseDTO(
    Integer id,
    String nombres,
    String email
) {}
