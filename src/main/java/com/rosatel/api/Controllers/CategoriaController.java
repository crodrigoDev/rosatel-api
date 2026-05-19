package com.rosatel.api.Controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rosatel.api.Models.ApiResponse;
import com.rosatel.api.Services.CategoriaService;
import com.rosatel.api.dtos.Categoria.CategoriaResponse;

import lombok.RequiredArgsConstructor;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/categorias")
@RequiredArgsConstructor
public class CategoriaController {
    private final CategoriaService categoriaService;

    @GetMapping
    public ResponseEntity<ApiResponse<List<CategoriaResponse>>> categorias() {
        List<CategoriaResponse> response = categoriaService.getAllCategorias().stream()
            .map(c -> CategoriaResponse.builder()
                .id(c.getId())
                .detalle(c.getDetalle())
                .build()
            ).toList();
        return ResponseEntity.ok( ApiResponse.<List<CategoriaResponse>>builder()
            .success(true)
            .message("Categorias obtenidas")
            .data(response)
            .build()
        );
    }
    
}
