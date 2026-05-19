package com.rosatel.api.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rosatel.api.Models.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Integer>{}
