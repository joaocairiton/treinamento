package com.cairiton.mega.itemdacompra;

import com.cairiton.mega.exception.EntidadeNaoEncontradaException;

public class ItemDaCompraNaoEncontradoException extends EntidadeNaoEncontradaException {
    
    private static final long serialVersionUID = 1L;
    
    public ItemDaCompraNaoEncontradoException(final String mensagem) {
        super(mensagem);
    }
    
    public ItemDaCompraNaoEncontradoException(
            final String mensagem,
            final Throwable causa) {
        super(mensagem);
    }
    
    public ItemDaCompraNaoEncontradoException(final Integer itemCompraId) {
        this(String.format("Não existe um cadastro do Item-Compra com código %d", itemCompraId));
    }
    
    public ItemDaCompraNaoEncontradoException(
            final Integer itemCompraId,
            final Throwable causa) {
        this(String.format("Não existe um cadastro do Item-Compra com código %d", itemCompraId), causa);
    }
    
}
