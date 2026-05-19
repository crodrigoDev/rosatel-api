package com.rosatel.api.Models;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data
@EqualsAndHashCode(callSuper = true)
@Table(name = "producto")
public class Producto extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Integer id;
    private String detalle;
    private String descripcion;
    @Column(name = "precio", nullable = false, precision = 10, scale = 2)
    private BigDecimal precio;
    private Integer stock;
    @Column(name = "imagen_url", nullable = true)
    private String imagenUrl;
    
    @ManyToOne
    @JoinColumn(name = "id_subcategoria", insertable = false, updatable = false)
    @JsonBackReference("subcategoria-productos")
    private Subcategoria subcategoria;

    @ManyToMany
    @JsonIgnore
    @JoinTable(
        name = "producto_color",
        joinColumns = @JoinColumn(name = "producto_id"),
        inverseJoinColumns = @JoinColumn(name = "color_id")
    )
    private Set<Color> colores = new HashSet<>();

    @ManyToMany
    @JsonIgnore
    @JoinTable(
        name = "producto_ocasion",
        joinColumns = @JoinColumn(name = "producto_id"),
        inverseJoinColumns = @JoinColumn(name = "ocasion_id")
    )
    private Set<Ocasion> ocasiones = new HashSet<>();
}
