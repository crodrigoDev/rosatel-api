package com.rosatel.api.Controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rosatel.api.Models.ApiResponse;
import com.rosatel.api.Services.AuthService;
import com.rosatel.api.dtos.Auth.AuthResponseDTO;
import com.rosatel.api.dtos.Auth.LoginRequestDTO;
import com.rosatel.api.dtos.Auth.RegisterRequestDTO;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {
    private final AuthService authService;

    @PostMapping("login")
    public ResponseEntity<ApiResponse<AuthResponseDTO>> login(@RequestBody LoginRequestDTO request, HttpServletResponse response) {
        AuthResponseDTO res = authService.login(request, response);
        return ResponseEntity.ok(ApiResponse.<AuthResponseDTO>builder()
                .success(true)
                .message("Inicio de sesion correctamente")
                .data(res).build());
    }

    @PostMapping("register")
    public ResponseEntity<ApiResponse<AuthResponseDTO>> register(@RequestBody RegisterRequestDTO request, HttpServletResponse response) {
        AuthResponseDTO res = authService.register(request, response);
        return ResponseEntity.status(HttpStatus.CREATED).body(ApiResponse.<AuthResponseDTO>builder()
                .success(true)
                .message("Registro correctamente")
                .data(res).build());
    }
}
