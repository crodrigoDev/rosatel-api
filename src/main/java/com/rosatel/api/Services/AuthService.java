package com.rosatel.api.Services;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.rosatel.api.Exceptions.EmailAlreadyExitsException;
import com.rosatel.api.Models.Usuario;
import com.rosatel.api.Repositories.UsuarioRepository;
import com.rosatel.api.dtos.Auth.AuthResponseDTO;
import com.rosatel.api.dtos.Auth.LoginRequestDTO;
import com.rosatel.api.dtos.Auth.RegisterRequestDTO;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthService {
    private final UsuarioRepository usuarioRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    public AuthResponseDTO login(LoginRequestDTO request, HttpServletResponse response) {
        Authentication auth = authenticationManager.authenticate(
            new UsernamePasswordAuthenticationToken(request.email(), request.password())
        );
        Usuario usuario = (Usuario)auth.getPrincipal();
        String token = jwtService.generateToken(usuario);
        jwtService.crearJwtCookie(token, response);
        AuthResponseDTO authResponse = AuthResponseDTO.builder()
            .id(usuario.getId())
            .nombres(usuario.getNombres())
            .email(usuario.getEmail())
            .build();
        return authResponse;
    }

    @Transactional
    public AuthResponseDTO register(RegisterRequestDTO request, HttpServletResponse response) {
        if(usuarioRepository.findByEmail(request.email()).isPresent())
            throw new EmailAlreadyExitsException("El correo ya esta en uso.");
        Usuario usuario = usuarioRepository.save(Usuario.builder()
            .nombres(request.nombres())
            .apellidos(request.apellidos())
            .email(request.email())
            .password(passwordEncoder.encode(request.password()))
            .build());
        String token = jwtService.generateToken(usuario);
        jwtService.crearJwtCookie(token, response);
        return AuthResponseDTO.builder()
            .id(usuario.getId())
            .nombres(usuario.getNombres())
            .email(usuario.getEmail())
            .build();
    }

}
