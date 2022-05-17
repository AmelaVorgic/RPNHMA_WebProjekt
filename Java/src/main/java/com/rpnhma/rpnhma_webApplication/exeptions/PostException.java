package com.rpnhma.rpnhma_webApplication.exeptions;

public class PostException extends RuntimeException {
    public PostException(final String postNotFound) {
        super(postNotFound);
    }
}
