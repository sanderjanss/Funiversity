package com.switchfullywork.funiversity.api;

import com.switchfullywork.funiversity.exceptions.NoSuchProfessorException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@ControllerAdvice
public class ControllerExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value = NullPointerException.class)
    protected void nullpointerException(NullPointerException ex, HttpServletResponse response) throws IOException {
        response.sendError(HttpStatus.BAD_REQUEST.value(), "Professor is null and cant be null");
    }

    @ExceptionHandler(value = NoSuchProfessorException.class)
    protected void nosuchprofessorException(NoSuchProfessorException nspe, HttpServletResponse response) throws  IOException{
        response.sendError(HttpStatus.NOT_FOUND.value(), "We could not find a Professor for the provided ID");
    }

}
