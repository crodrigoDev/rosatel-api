package com.rosatel.api.Models;

import java.util.HashSet;
import java.util.Set;

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
    private Integer id;
    private String detalle;
    private String descripcion;
    
    @ManyToMany
    @JsonIgnore
    @JoinTable(
        name = "producto_color",
        joinColumns = @JoinColumn(name = "producto_id"),
        inverseJoinColumns = @JoinColumn(name = "color_id")
    )
    private Set<Color> colores = new HashSet<>();
}
