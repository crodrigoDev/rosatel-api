package com.rosatel.api.Controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rosatel.api.Models.ApiResponse;
import com.rosatel.api.Services.ProductoService;
import com.rosatel.api.dtos.Producto.ColorDTO;
import com.rosatel.api.dtos.Producto.DetalleDTO;
import com.rosatel.api.dtos.Producto.ProductoDTO;
import com.rosatel.api.Models.Producto;

import lombok.RequiredArgsConstructor;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@RestController
@RequestMapping("/productos")
@RequiredArgsConstructor
public class ProductoController {
    private final ProductoService productoService;

    @GetMapping
    public ResponseEntity<ApiResponse<List<ProductoDTO>>> productos() {
        List<ProductoDTO> productos = productoService.getProductos()
            .stream()
            .map(p -> ProductoDTO.builder()
                .id(p.getId())
                .detalle(p.getDetalle())
                .precio(p.getPrecio())
                .imagen_url(p.getImagen_url())
                .build())
            .toList();
        return ResponseEntity.ok(new ApiResponse<List<ProductoDTO>>(true, null, productos));
    }

    @GetMapping("{id}")
    public ResponseEntity<ApiResponse<DetalleDTO>> producto(@PathVariable Integer id) {
        Producto producto = productoService.getProducto(id);
        List<ColorDTO> colores = Optional.ofNullable(producto.getColores())
                .orElse(Collections.emptySet())
                .stream()
                .map(c -> new ColorDTO(c.getId(), c.getDetalle()))
                .toList();

        DetalleDTO detalleProducto = DetalleDTO.builder()
                .id(producto.getId())
                .detalle(producto.getDetalle())
                .descripcion(producto.getDescripcion())
                .precio(producto.getPrecio())
                .stock(producto.getStock())
                .imagen_url(producto.getImagen_url())
                .colores(colores)
                .build();
        return ResponseEntity.ok(new ApiResponse<>(true, "Producto obtenido", detalleProducto));
    }
    
    @GetMapping("subcategorias/{id}")
    public ResponseEntity<ApiResponse<List<ProductoDTO>>> productosBySubCategoria(@PathVariable Integer id) {
        List<ProductoDTO> productos = productoService.getProductosBySubcategoria(id)
                .stream()
                .map(p -> 
                    ProductoDTO
                    .builder()
                    .id(p.getId())
                    .detalle(p.getDetalle())
                    .precio(p.getPrecio())
                    .imagen_url(p.getImagen_url())
                    .build()
                )
                .toList();
        if(productos.isEmpty()) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(new ApiResponse<>(true, "Productos obtenidos", productos));
    }
    
    
}
