package com.cairiton.mega.compra;

import com.cairiton.mega.exception.EntidadeNaoEncontradaException;

public class CompraNaoEncontradaException extends EntidadeNaoEncontradaException {
    
    private static final long serialVersionUID = 1L;
    
    public CompraNaoEncontradaException(final String mensagem) {
        super(mensagem);
        
    }
    
    public CompraNaoEncontradaException(
            final String mensagem,
            final Throwable causa) {
        super(mensagem);
        
    }
    
    public CompraNaoEncontradaException(final Integer compraId) {
        this(String.format("Não existe um cadastro da Compra com código %d", compraId));
    }
    
    public CompraNaoEncontradaException(
            final Integer compraId,
            final Throwable causa) {
        this(String.format("Não existe um cadastro da Compra com código %d", compraId), causa);
    }
}
