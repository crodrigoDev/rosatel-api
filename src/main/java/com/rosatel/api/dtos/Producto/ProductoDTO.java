package com.rosatel.api.dtos.Producto;

import java.math.BigDecimal;

import lombok.Builder;

@Builder
public record ProductoDTO(
    Integer id,
    String detalle,
    BigDecimal precio,
    String imagen_url
) {} 
