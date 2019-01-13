package com.amm.cloud.basic.bk.ratingservice.infrastructure.exception;

public class RatingNotFoundException extends RuntimeException {
    public RatingNotFoundException(){
        super();
    }
    public RatingNotFoundException(String message){
        super(message);
    }

    public RatingNotFoundException(String message, Throwable cause){
        super(message,cause);
    }
}
