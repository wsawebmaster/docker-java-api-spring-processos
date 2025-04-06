package com.dho.processos.exceptions.processo;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.CONFLICT)
public class ProcessoExistenteException extends RuntimeException {
    public ProcessoExistenteException(String message) {
        super(message);
    }
}
