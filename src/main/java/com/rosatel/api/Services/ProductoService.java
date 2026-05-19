package com.rosatel.api.Services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.rosatel.api.Models.Producto;
import com.rosatel.api.Repositories.ProductoRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProductoService {
    private final ProductoRepository productoRepository;
    
    public Producto getProducto(Integer id){
        return productoRepository.findById(id).get();
    }
    public List<Producto> getProductos(){
        return productoRepository.findAll();
    }
    public List<Producto> getProductosBySubcategoria(Integer idSubcategoria){
        return productoRepository.findBySubcategoriaId(idSubcategoria);
    }
    public List<Producto> getProductosByOcasiones(Integer idOcasion){
        return productoRepository.findByOcasiones_Id(idOcasion);
    }
}
