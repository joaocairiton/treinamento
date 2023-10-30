package com.cairiton.mega.bairro;

import com.cairiton.mega.exception.EntidadeNaoEncontradaException;

public class BairroNaoEncontradoException extends EntidadeNaoEncontradaException {
    
    private static final long serialVersionUID = 1L;
    
    private static final String MSG_BAIRRO_NAO_ENCONTRADO = "Não existe um cadastro do Bairro com código %d";
    
    public BairroNaoEncontradoException(final String mensagem) {
        super(mensagem);
        
    }
    
    public BairroNaoEncontradoException(
            final String mensagem,
            final Throwable causa) {
        super(mensagem);
        
    }
    
    public BairroNaoEncontradoException(final Integer bairroId) {
        this(String.format(MSG_BAIRRO_NAO_ENCONTRADO, bairroId));
    }
    
    public BairroNaoEncontradoException(
            final Integer bairroId,
            final Throwable causa) {
        this(String.format(MSG_BAIRRO_NAO_ENCONTRADO, bairroId), causa);
    }
    
}
