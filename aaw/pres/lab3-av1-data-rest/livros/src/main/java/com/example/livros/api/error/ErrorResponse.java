package com.example.livros.api.error;

import java.time.ZonedDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.With;

@AllArgsConstructor
@NoArgsConstructor
@Data
@With
public class ErrorResponse {

    private ZonedDateTime timestamp;
    
    private int status;
    
    private String error;
    
    private String message;
    
    private String path;
}
