package com.rosatel.api.dtos.Auth;

public record RegisterRequestDTO(
    String email,
    String password,
    String nombres,
    String apellidos
) {}
