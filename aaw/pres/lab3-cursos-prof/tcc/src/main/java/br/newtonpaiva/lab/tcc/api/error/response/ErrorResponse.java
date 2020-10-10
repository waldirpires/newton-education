package br.newtonpaiva.lab.tcc.api.error.response;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.With;

@AllArgsConstructor
@NoArgsConstructor
@Data
@With
public class ErrorResponse {

    private LocalDateTime timestamp;
    
    private Integer status;
    
    private String error;
    
    private String message;
}
