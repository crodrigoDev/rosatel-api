package com.rosatel.api.dtos.Auth;

public record LoginRequestDTO(
    String email,
    String password
){}
