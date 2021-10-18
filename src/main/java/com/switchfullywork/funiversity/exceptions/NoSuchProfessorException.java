package com.switchfullywork.funiversity.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class NoSuchProfessorException extends RuntimeException{

    public NoSuchProfessorException(String message) {
        super(message);
    }
}
