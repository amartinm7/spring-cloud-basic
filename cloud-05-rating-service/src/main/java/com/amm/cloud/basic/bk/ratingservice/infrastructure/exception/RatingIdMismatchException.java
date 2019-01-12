package com.amm.cloud.basic.bk.ratingservice.infrastructure.exception;

public class RatingIdMismatchException extends RuntimeException {
    public RatingIdMismatchException(){
        super();
    }
    public RatingIdMismatchException(String message, Throwable cause){
        super(message,cause);
    }
}
