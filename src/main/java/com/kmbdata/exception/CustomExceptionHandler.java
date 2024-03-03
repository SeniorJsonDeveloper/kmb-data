package com.kmbdata.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

@RestControllerAdvice
public class CustomExceptionHandler {
    @ExceptionHandler(value = BadRequestException.class)
    public ResponseEntity<ErrorBody> refreshTokenException(BadRequestException e, WebRequest request){
        return buildResponse(HttpStatus.BAD_REQUEST,e,request);
    }
    @ExceptionHandler(value = NotFoundException.class)
    public ResponseEntity<ErrorBody> notFoundExHandler(NotFoundException e,WebRequest request){
        return buildResponse(HttpStatus.NOT_FOUND,e,request);
    }

    private ResponseEntity<ErrorBody> buildResponse(HttpStatus httpStatus, Exception e, WebRequest request) {
        return ResponseEntity
                .status(httpStatus)
                .body(ErrorBody.builder()
                        .message(e.getMessage())
                        .description(request.getDescription(false))
                        .build());

    }
}
