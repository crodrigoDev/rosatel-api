package com.rosatel.api.Services;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.rosatel.api.Models.Usuario;
import com.rosatel.api.Repositories.UsuarioRepository;
import com.rosatel.api.dtos.Auth.LoginRequestDTO;
import com.rosatel.api.dtos.Auth.RegisterRequestDTO;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthService {
    private final UsuarioRepository usuarioRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    public String login(LoginRequestDTO request) {
        authenticationManager.authenticate(
            new UsernamePasswordAuthenticationToken(request.email(), request.password())
        );

        Usuario usuario = usuarioRepository.findByEmail(request.email())
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

        return jwtService.generateToken(usuario);
    }

    public Usuario register(RegisterRequestDTO request) {
        Usuario usuario = new Usuario();
        usuario.setEmail(request.email());
        usuario.setNombres(request.nombres());
        usuario.setApellidos(request.apellidos());
        usuario.setPassword(passwordEncoder.encode(request.password()));
        return usuarioRepository.save(usuario);
    }

}
