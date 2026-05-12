package com.rosatel.api.dtos;

public record RegisterRequestDTO(
    String email,
    String password,
    String nombres,
    String apellidos
) {}
