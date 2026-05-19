package com.rosatel.api.dtos.Auth;

import lombok.Builder;

@Builder
public record LoginRequestDTO(
    String email,
    String password
){}
