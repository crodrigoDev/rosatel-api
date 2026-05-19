package com.rosatel.api.Handlers;

import java.time.LocalDateTime;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import com.rosatel.api.Exceptions.EmailAlreadyExitsException;

import com.rosatel.api.dtos.Api.ErrorDTO;

@RestControllerAdvice
public class GlobalHandlerExceptions {
    @ExceptionHandler(EmailAlreadyExitsException.class)
    public ResponseEntity<ErrorDTO> handleEmailAlreadyExitsException(EmailAlreadyExitsException e){
        return ResponseEntity.status(HttpStatus.CONFLICT).body(
            ErrorDTO.builder()
            .success(false)
            .message(e.getMessage())
            .timestamp(LocalDateTime.now())
            .build()
        );
    }

    @ExceptionHandler(BadCredentialsException.class)
    public ResponseEntity<ErrorDTO> handleBadCredentialsException(BadCredentialsException e){
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(
            ErrorDTO.builder()
                .success(false)
                .message("Credenciales invalidas")
                .timestamp(LocalDateTime.now())
                .build()
        );
    }

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<ErrorDTO> handleRuntimeException(RuntimeException e){
        return ResponseEntity.badRequest().body(
            ErrorDTO.builder()
                .success(false)
                .message(e.getMessage())
                .timestamp(LocalDateTime.now())
                .build()
        );
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorDTO> handleException(Exception e){
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(
            ErrorDTO.builder()
                .success(false)
                .message("Error interno del servidor")
                .timestamp(LocalDateTime.now())
                .build()
        );
    }
}
