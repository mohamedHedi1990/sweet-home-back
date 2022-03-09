package org.sweetrooms.security;

import lombok.Data;

@Data
public class LoginRequest {
    private Long userId;

    private String username;

    private String userPassword;
}
