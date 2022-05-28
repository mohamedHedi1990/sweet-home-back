package org.sweetrooms.client.dtos.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PasswordDtoRequest {

    private String password;

    private  String token;

    private String confirmedPassword;
}