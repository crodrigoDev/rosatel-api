package com.rosatel.api.dtos.Categoria;

import lombok.Builder;

@Builder
public record CategoriaResponse(
    Integer id,
    String detalle
) {
    
}
