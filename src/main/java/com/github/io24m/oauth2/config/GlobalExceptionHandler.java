package com.github.io24m.oauth2.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {


    @ExceptionHandler(Exception.class)
    public ResponseEntity exceptionHandler(HttpServletRequest request, Exception exception) throws Exception {
        log.error("error",exception);
        return new ResponseEntity<Object>("", HttpStatus.valueOf(500));
    }
}