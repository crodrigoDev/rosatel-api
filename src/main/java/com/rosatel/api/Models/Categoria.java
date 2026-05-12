package com.rosatel.api.Models;

import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data
@EqualsAndHashCode(callSuper = true)
@Table(name = "categoria")
public class Categoria extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(nullable = false)
    private String detalle;

    @OneToMany(mappedBy = "categoria")
    @JsonManagedReference
    private Set<Subcategoria> subcategorias = new HashSet<>();
}
