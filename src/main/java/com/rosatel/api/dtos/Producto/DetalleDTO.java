package com.rosatel.api.dtos.Producto;

import java.math.BigDecimal;
import java.util.List;

import lombok.Builder;

@Builder
public record DetalleDTO(
    Integer id,
    String detalle,
    String descripcion,
    BigDecimal precio,
    Integer stock,
    String imagen_url,
    List<ColorDTO> colores
) {}
