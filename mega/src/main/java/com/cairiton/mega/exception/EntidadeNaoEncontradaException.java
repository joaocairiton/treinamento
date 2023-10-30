package com.cairiton.mega.exception;

public class EntidadeNaoEncontradaException extends NegocioException {
    
    private static final long serialVersionUID = 1L;
    
    public EntidadeNaoEncontradaException(final String mensagem) {
        super(mensagem);
    }
    
    public EntidadeNaoEncontradaException(final String mensagem, final Throwable causa) {
        super(mensagem, causa);
    }
    
}
