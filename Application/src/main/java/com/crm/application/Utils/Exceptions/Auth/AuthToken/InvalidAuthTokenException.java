package com.crm.application.Utils.Exceptions.Auth.AuthToken;

public class InvalidAuthTokenException extends Exception {
    private InvalidAuthTokenException(String message) {
        super(message);
    }

    public static InvalidAuthTokenException expired() {
        return new InvalidAuthTokenException("Auth token is expired");
    }

    public static InvalidAuthTokenException unsupported() {
        return new InvalidAuthTokenException("Auth token is unsupported");
    }

    public static InvalidAuthTokenException malformed() {
        return new InvalidAuthTokenException("Auth token is malformed");
    }

    public static InvalidAuthTokenException invalidSignature() {
        return new InvalidAuthTokenException("Auth token has invalid signature");
    }

    public static InvalidAuthTokenException invalid() {
        return new InvalidAuthTokenException("Auth token is invalid");
    }
}
