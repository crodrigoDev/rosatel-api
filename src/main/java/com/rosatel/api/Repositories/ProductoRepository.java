package com.rosatel.api.Repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.rosatel.api.Models.Producto;

public interface ProductoRepository extends JpaRepository<Producto, Integer>, JpaSpecificationExecutor<Producto>{
    List<Producto> findBySubcategoriaId(Integer idSubcategoria);
    List<Producto> findBySubcategoria_Categoria_Id(Integer idCategoria);
}
