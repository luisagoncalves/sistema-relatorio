package com.dev.sistema.relatorio.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(AttachmentNotFoundException.class)
    public ResponseEntity<String> handleAttachmentNotFoundException(AttachmentNotFoundException exception){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(exception.getMessage());
    }

    @ExceptionHandler(AttachmentNoContentException.class)
    public ResponseEntity<String> handleAttachmentNoContentException(AttachmentNoContentException exception){
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(exception.getMessage());
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleGenericException(Exception ex) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ex.getMessage());
    }
}
