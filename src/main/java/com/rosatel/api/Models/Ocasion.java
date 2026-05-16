package com.rosatel.api.Models;


import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true, onlyExplicitlyIncluded = true)
@Entity
@Table(name = "ocasion")
public class Ocasion extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Integer id;
    private String detalle;
    @ManyToMany(mappedBy = "ocasiones")
    @JsonBackReference("producto-ocasion")
    private Set<Producto> productos = new HashSet<>();
}
