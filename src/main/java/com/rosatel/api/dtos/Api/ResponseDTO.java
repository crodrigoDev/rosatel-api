package com.rosatel.api.dtos.Api;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Builder;

@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public record ResponseDTO<T>(
    Boolean success,
    String message,
    T data
) {
    public ResponseDTO(Boolean success, String message){
        this(success, message, null);
    }
}
