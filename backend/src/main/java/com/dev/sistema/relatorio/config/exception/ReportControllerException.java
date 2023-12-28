package com.dev.sistema.relatorio.config.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
public class ReportControllerException extends RuntimeException {
  public ReportControllerException(String message){
    super(message);
  }
}
