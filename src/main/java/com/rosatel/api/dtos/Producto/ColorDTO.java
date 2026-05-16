package com.rosatel.api.dtos.Producto;

import lombok.Builder;

@Builder
public record ColorDTO(
    Integer id,
    String detalle
) {}
