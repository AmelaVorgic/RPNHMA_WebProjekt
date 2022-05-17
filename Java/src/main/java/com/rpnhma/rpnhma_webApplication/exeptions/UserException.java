package com.rpnhma.rpnhma_webApplication.exeptions;

public class UserException extends RuntimeException{
    public UserException(final String userNotFound) {
        super(userNotFound);
    }
}
