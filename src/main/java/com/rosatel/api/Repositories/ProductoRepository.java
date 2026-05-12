package com.rosatel.api.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rosatel.api.Models.Producto;

public interface ProductoRepository extends JpaRepository<Producto, Integer>{
    
}
