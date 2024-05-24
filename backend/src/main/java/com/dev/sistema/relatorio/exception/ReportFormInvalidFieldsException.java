package com.dev.sistema.relatorio.exception;

public class ReportFormInvalidFieldsException extends RuntimeException{
    private static final String DEFAULT_MESSAGE = "Invalid fields in the report form.";
    public ReportFormInvalidFieldsException() {
        super(DEFAULT_MESSAGE);
    }
}
