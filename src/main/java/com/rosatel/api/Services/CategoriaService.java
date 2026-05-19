package com.rosatel.api.Services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.rosatel.api.Models.Categoria;
import com.rosatel.api.Repositories.CategoriaRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CategoriaService {
    private final CategoriaRepository categoriaRepository;

    public List<Categoria> getAllCategorias(){
        return categoriaRepository.findAll();
    }
}
