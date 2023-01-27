package com.crm.application.Utils.Exceptions.Auth.Duplicate;

public class UserDuplicateException extends Exception{
    public UserDuplicateException(String login) {
        super(String.format("User with login %s already exists", login));
    }
}
