package com.rpnhma.rpnhma_webApplication.exeptions;

public class CommentException extends RuntimeException {
    public CommentException(final String commentNotFound) {
        super(commentNotFound);
    }
}
