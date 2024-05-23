package com.dev.sistema.relatorio.exception;

public class AttachmentNotFoundException extends RuntimeException{
    public AttachmentNotFoundException(String message){
        super(message);
    }
}
