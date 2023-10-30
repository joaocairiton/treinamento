package com.cairiton.mega.pessoa;

import com.cairiton.mega.exception.EntidadeNaoEncontradaException;

public class PessoaNaoEncontradoException extends EntidadeNaoEncontradaException {
    
    private static final long serialVersionUID = 1L;
    
    public PessoaNaoEncontradoException(final String mensagem) {
        super(mensagem);
        
    }
    
    public PessoaNaoEncontradoException(
            final String mensagem,
            final Throwable causa) {
        super(mensagem);
        
    }
    
    public PessoaNaoEncontradoException(final Integer pessoaId) {
        this(String.format("Não existe uma cadastro da Pessoa com código %d", pessoaId));
    }
    
    public PessoaNaoEncontradoException(
            final Integer pessoaId,
            final Throwable causa) {
        this(String.format("Não existe uma cadastro da Pessoa com código %d", pessoaId), causa);
    }
    
}
