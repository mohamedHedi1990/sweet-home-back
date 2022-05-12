package org.sweetrooms.security;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class LoginRequest {
    private Long userId;

    @JsonProperty("email")
    private String email;

    private String userPassword;
}
