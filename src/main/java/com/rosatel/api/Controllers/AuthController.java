package com.rosatel.api.Controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rosatel.api.Models.ApiResponse;
import com.rosatel.api.Models.Usuario;
import com.rosatel.api.Services.AuthService;
import com.rosatel.api.dtos.Auth.AuthResponseDTO;
import com.rosatel.api.dtos.Auth.LoginRequestDTO;
import com.rosatel.api.dtos.Auth.RegisterRequestDTO;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {
    private final AuthService authService;
    private final UserDetailsService userDetailsService;

    @PostMapping("login")
    public ResponseEntity<ApiResponse<AuthResponseDTO>> login(@RequestBody LoginRequestDTO request, HttpServletResponse response) {
        String jwt = authService.login(request);
        Usuario usuario = (Usuario)userDetailsService.loadUserByUsername(request.email());

        // creacion de cookie
        Cookie cookie = new Cookie("jwt", jwt);
        cookie.setHttpOnly(true);
        cookie.setSecure(false);
        cookie.setPath("/");
        cookie.setMaxAge(86400);

        response.addCookie(cookie);
        AuthResponseDTO authresponse = new AuthResponseDTO(usuario.getId(),usuario.getNombres(),usuario.getEmail());
        ApiResponse<AuthResponseDTO> apiresponse = ApiResponse.<AuthResponseDTO>builder()
            .success(true)
            .message("Se inicio sesion correctamente")
            .data(authresponse)
            .build();
        return ResponseEntity.ok(apiresponse);
    }

    @PostMapping("register")
    public ResponseEntity<String> register(@RequestBody RegisterRequestDTO request) {
        authService.register(request);
        return ResponseEntity.ok("Usuario registrado exitosamente");
    }

    @PostMapping("logout")
    public void logout(HttpServletResponse response) {
        final Cookie cookie = new Cookie("jwt", null);
        cookie.setMaxAge(0);
    }
    
    
}
