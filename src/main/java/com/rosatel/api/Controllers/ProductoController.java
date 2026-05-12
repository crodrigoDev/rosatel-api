package com.rosatel.api.Controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rosatel.api.Models.ApiResponse;
import com.rosatel.api.Services.ProductoService;
import com.rosatel.api.Models.Producto;

import lombok.RequiredArgsConstructor;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/productos")
@RequiredArgsConstructor
public class ProductoController {
    private final ProductoService productoService;

    @GetMapping
    public ResponseEntity<ApiResponse<List<Producto>>> productos() {
        List<Producto> productos = productoService.getProductos();
        ApiResponse<List<Producto>> response = new ApiResponse<List<Producto>>(true, null, productos);
        return ResponseEntity.ok(response);
    }
    
}
