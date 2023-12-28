package com.dev.sistema.relatorio.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
public class ReportException extends RuntimeException{
  public ReportException(String message){
    super(message);
  }
}
