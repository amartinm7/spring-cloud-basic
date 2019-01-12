package com.amm.cloud.basic.bk.bookservice.infrastructure.exception;

public class BookNotFoundException extends RuntimeException {
    public BookNotFoundException(){
        super();
    }
    public BookNotFoundException(String message, Throwable cause){
        super(message,cause);
    }
}
