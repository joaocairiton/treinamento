package com.cairiton.mega.profissao;

import com.cairiton.mega.exception.EntidadeNaoEncontradaException;

public class ProfissaoNaoEncontradoException extends EntidadeNaoEncontradaException {
    
    private static final long serialVersionUID = 1L;
    
    public ProfissaoNaoEncontradoException(final String mensagem) {
        super(mensagem);
        
    }
    
    public ProfissaoNaoEncontradoException(final String mensagem,
            final Throwable causa) {
        super(mensagem);
        
    }
    
    public ProfissaoNaoEncontradoException(final Integer profissaoId) {
        this(String.format("Não existe um cadastro de Profissao com código %d", profissaoId));
    }
    
    public ProfissaoNaoEncontradoException(final Integer profissaoId, final Throwable causa) {
        this(String.format("Não existe um cadastro de Profissao com código %d", profissaoId), causa);
    }
    
}
