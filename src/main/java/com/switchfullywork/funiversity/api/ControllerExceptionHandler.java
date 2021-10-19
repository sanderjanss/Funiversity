package com.switchfullywork.funiversity.api;

import com.switchfullywork.funiversity.domain.professor.ProfessorDTO;
import com.switchfullywork.funiversity.exceptions.NoSuchProfessorException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URI;

//WAY ONE of converting exceptions to an HTTP response Status
@ControllerAdvice
public class ControllerExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value = {NullPointerException.class})
    protected void nullpointerException(NullPointerException npe, HttpServletResponse response) throws IOException {
        response.sendError(HttpStatus.BAD_REQUEST.value(), "Professor is null and cant be null");
    }


//    @ExceptionHandler(value = NoSuchProfessorException.class)
//    protected void nosuchprofessorException(NoSuchProfessorException nspe, HttpServletResponse response) throws  IOException{
//        response.sendError(HttpStatus.NOT_FOUND.value(), "We could not find a Professor for the provided ID");
//    }

//    @ExceptionHandler(value = {NullPointerException.class, NoSuchProfessorException.class})
//    protected void nullpointerException(RuntimeException e, HttpServletResponse response) throws IOException {
//        response.sendError(HttpStatus.BAD_REQUEST.value(), "Professor is null and cant be null");
//    }

//    @ExceptionHandler
//    protected ResponseEntity<String> handle(NoSuchProfessorException noSuchProfessorException){
//        URI location = URI.create("");
//        HttpHeaders responseHeaders = new HttpHeaders();
//        responseHeaders.setLocation(location);
//        responseHeaders.set("Content-type", "application/json");
//        return new ResponseEntity<>("Hello World", responseHeaders, HttpStatus.CREATED);
//    }


//    @ExceptionHandler
//    @Override
//    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
//                                                                  HttpHeaders headers,
//                                                                  HttpStatus status,
//                                                                  WebRequest request) {
//        headers.add("Accept", "application/json");
//
//
//        return super.handleMethodArgumentNotValid(ex, headers, HttpStatus.OK, request);
//    }
}
