package com.rosatel.api.Controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;


@RestController
@RequestMapping("/rosatel-api/v1")
@RequiredArgsConstructor
public class UsuarioController {
    @GetMapping("perfil")
    public String perfil() {
        return "perfil obtenido";
    }
    
}
