package com.rosatel.api.Models;

import java.util.HashSet;
import java.util.Set;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data
@EqualsAndHashCode(callSuper = true)
@Table(name = "color")
public class Color extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String detalle;

    @ManyToMany(mappedBy = "colores")
    private Set<Producto> productos = new HashSet<>();

}
