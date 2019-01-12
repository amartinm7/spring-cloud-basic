package com.amm.cloud.basic.bk.bookservice.infrastructure.exception;

public class BookIdMismatchException extends RuntimeException {
    public BookIdMismatchException(){
        super();
    }
    public BookIdMismatchException(String message, Throwable cause){
        super(message,cause);
    }
}
