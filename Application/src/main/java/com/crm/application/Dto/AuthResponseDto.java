package com.crm.application.Dto;

public class AuthResponseDto {
    public static final String type = "Bearer";
    public String accessToken;
    public String refreshToken;

    public AuthResponseDto(String accessToken, String refreshToken) {
        this.accessToken = accessToken;
        this.refreshToken = refreshToken;
    }

    public AuthResponseDto() {
    }
}
