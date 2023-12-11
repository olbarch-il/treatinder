package com.treat.treatinder.model.dto;

import lombok.Data;

@Data
public class TokenResponse {
    private String token_type;
    private int expires_in;
    private String access_token;
}