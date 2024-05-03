package com.example.ApplicationChallenge.DTO;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ErrorDTO {
    private String mensaje;
    private String codigo;
}
