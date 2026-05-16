package com.rosatel.api.Models;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "detalle_carrito")
public class DetalleCarrito {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @ManyToOne
    @JsonBackReference("carrito-detalles")
    @JoinColumn(name = "id_carrito")
    private Carrito carrito;
    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "id_producto")
    private Producto producto;
    private Integer cantidad;
    private BigDecimal precio_unitario_capturado;
}
