package com.cairiton.mega.endereco;

import com.cairiton.mega.exception.EntidadeNaoEncontradaException;

public class EnderecoNaoEncontradoException extends EntidadeNaoEncontradaException {
    
    private static final long serialVersionUID = 1L;
    
    public EnderecoNaoEncontradoException(final String mensagem) {
        super(mensagem);
    }
    
    public EnderecoNaoEncontradoException(
            final String mensagem,
            final Throwable causa) {
        
        super(mensagem, causa);
    }
    
    public EnderecoNaoEncontradoException(final Integer enderecoId) {
        this(String.format("Não existe um cadastro do Endereco com código %d", enderecoId));
    }
    
    public EnderecoNaoEncontradoException(
            final Integer enderecoId,
            final Throwable causa) {
        
        this(String.format("Não existe um cadastro do Endereco com código %d", enderecoId), causa);
    }
    
}
