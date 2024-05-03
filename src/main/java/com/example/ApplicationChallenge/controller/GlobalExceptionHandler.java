package com.example.ApplicationChallenge.controller;

import com.example.ApplicationChallenge.DTO.ErrorDTO;
import com.example.ApplicationChallenge.exception.NotFoundRequestException;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.security.SignatureException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.authentication.AccountStatusException;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;


@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(NotFoundRequestException.class)
    public ResponseEntity<ErrorDTO> handleNotFoundRequestRequestException(NotFoundRequestException ex) {
        ErrorDTO errorResponse = ErrorDTO.builder().mensaje(ex.getMessage()).codigo(String.valueOf((ex.getCode().value()))).build();
        return new ResponseEntity<>(errorResponse, ex.getCode());
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorDTO> handleMethodArgumentNotValidException(MethodArgumentNotValidException ex) {
        return invalidRequestException(ex);
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<ErrorDTO> handleHttpMessageNotReadableException(HttpMessageNotReadableException ex) {
        return invalidRequestException(ex);
    }

    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    public ResponseEntity<ErrorDTO> handleHttpMessageNotReadableException(HttpRequestMethodNotSupportedException ex) {
        ErrorDTO errorResponse = ErrorDTO.builder().mensaje(ex.getMessage()).codigo(String.valueOf((ex.getStatusCode().value()))).build();
        return new ResponseEntity<>(errorResponse, ex.getStatusCode());
    }

    protected ResponseEntity<ErrorDTO> invalidRequestException(Exception ex) {
        ErrorDTO errorResponse = ErrorDTO.builder().mensaje("La solicitud es invalida").codigo(String.valueOf(HttpStatus.BAD_REQUEST.value())).build();
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(BadCredentialsException.class)
    public ResponseEntity<ErrorDTO> handleBadCredentialsException(BadCredentialsException ex) {
        ErrorDTO errorResponse = ErrorDTO.builder().mensaje("El nombre de usuario o contraseña son incorrectos").codigo(String.valueOf(HttpStatus.UNAUTHORIZED.value())).build();
        return new ResponseEntity<>(errorResponse, HttpStatus.UNAUTHORIZED);
    }

    @ExceptionHandler(AccountStatusException.class)
    public ResponseEntity<ErrorDTO> handleAccountStatusException(AccountStatusException ex) {
        ErrorDTO errorResponse = ErrorDTO.builder().mensaje("La cuenta esta bloqueada").codigo(String.valueOf(HttpStatus.FORBIDDEN.value())).build();
        return new ResponseEntity<>(errorResponse, HttpStatus.FORBIDDEN);
    }

    @ExceptionHandler(SignatureException.class)
    public ResponseEntity<ErrorDTO> handleSignatureException(SignatureException ex) {
        ErrorDTO errorResponse = ErrorDTO.builder().mensaje("JWT invalido").codigo(String.valueOf(HttpStatus.FORBIDDEN.value())).build();
        return new ResponseEntity<>(errorResponse, HttpStatus.FORBIDDEN);
    }

    @ExceptionHandler(AccessDeniedException.class)
    public ResponseEntity<ErrorDTO> handleAccessDeniedException(AccessDeniedException ex) {
        ErrorDTO errorResponse = ErrorDTO.builder().mensaje("No tiene autorizacion para acceder a este recurso").codigo(String.valueOf(HttpStatus.FORBIDDEN.value())).build();
        return new ResponseEntity<>(errorResponse, HttpStatus.FORBIDDEN);
    }

    @ExceptionHandler(ExpiredJwtException.class)
    public ResponseEntity<ErrorDTO> handleAccessDeniedException(ExpiredJwtException ex) {
        ErrorDTO errorResponse = ErrorDTO.builder().mensaje("JWT a expirado").codigo(String.valueOf(HttpStatus.FORBIDDEN.value())).build();
        return new ResponseEntity<>(errorResponse, HttpStatus.FORBIDDEN);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorDTO> handleException(Exception ex) {
        ErrorDTO errorResponse = ErrorDTO.builder().mensaje("error desconocido" + ex.getMessage()).codigo(String.valueOf(HttpStatus.INTERNAL_SERVER_ERROR.value())).build();
        return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
