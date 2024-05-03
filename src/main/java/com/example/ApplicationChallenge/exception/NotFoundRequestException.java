package com.example.ApplicationChallenge.exception;

import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
public class NotFoundRequestException extends RuntimeException{
   private HttpStatus code;
    public NotFoundRequestException() {
        super("Equipo no encontrado");
        this.code = HttpStatus.NOT_FOUND;
    }
}
