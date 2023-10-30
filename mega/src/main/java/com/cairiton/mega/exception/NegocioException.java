package com.cairiton.mega.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class NegocioException extends RuntimeException {
    
    private static final long serialVersionUID = 1L;
    
    public NegocioException(final String mensagem) {
        super(mensagem);
    }
    
    public NegocioException(final String mensagem, final Throwable causa) {
        super(mensagem, causa);
    }
    
}
