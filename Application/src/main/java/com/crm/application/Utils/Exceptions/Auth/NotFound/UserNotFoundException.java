package com.crm.application.Utils.Exceptions.Auth.NotFound;

public class UserNotFoundException extends Exception {

    public UserNotFoundException(String login) {
        super(String.format("User with login %s was not found", login));
    }
}
