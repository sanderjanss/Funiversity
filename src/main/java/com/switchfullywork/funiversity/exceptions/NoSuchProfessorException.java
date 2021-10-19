package com.switchfullywork.funiversity.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

//WAY TWO of converting exceptions to an HTTP response Status
@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class NoSuchProfessorException extends RuntimeException{

    public NoSuchProfessorException(String message) {
        super(message);
    }
}
