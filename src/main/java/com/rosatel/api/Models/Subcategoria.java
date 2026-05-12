package com.rosatel.api.Models;

import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
@Entity
@Data
@EqualsAndHashCode(callSuper = true)
@Table(name = "subcategoria")
public class Subcategoria extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(nullable = false)
    private String detalle;
    @ManyToOne
    @JoinColumn(name = "id_categoria", insertable = false, updatable = false)
    @JsonBackReference
    private Categoria categoria;
    private Integer id_categoria;

    @OneToMany(mappedBy = "subcategoria")
    @JsonBackReference
    private Set<Producto> productos = new HashSet<>();
}
