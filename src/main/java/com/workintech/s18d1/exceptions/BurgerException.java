package com.workintech.s18d1.exceptions;

import lombok.*;
import org.apache.logging.log4j.util.PerformanceSensitive;
import org.springframework.http.HttpStatus;
@Getter
@Setter
public class BurgerException extends RuntimeException{
    private HttpStatus httpStatus;
    public BurgerException( String message,HttpStatus httpStatus) {
        super(message);
        this.httpStatus = httpStatus;
    }


    public HttpStatus getStatus() {
        return httpStatus;
    }
}
