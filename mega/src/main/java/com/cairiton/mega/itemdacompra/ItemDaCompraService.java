package com.cairiton.mega.itemdacompra;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cairiton.mega.compra.CompraService;
import com.cairiton.mega.exception.EntidadeEmUsoException;
import com.cairiton.mega.relatorio.RelatorioUtil;

@Service
public class ItemDaCompraService {
    
    private static final String MENSAGEM_ITEM_DE_COMPRA_EM_USO = "Item da Compra de código %d não pode ser removido, pois está em uso";
    
    @Autowired
    private ItemDaCompraRepositorio itemDaCompraRepositorio;
    
    @Autowired
    private CompraService compraService;
    
    public byte[] imprimirTodos() {
        final Map<String, Object> parametros = new HashMap<>();
        parametros.put("TITULO", "megasoft");
        return RelatorioUtil.gerarPdf(parametros, this.itemDaCompraRepositorio.findAll(),
                this.getClass().getResourceAsStream("/relatorios/relatorio-de-item-de-compra/relatorio-item-da-compra.jasper"));
    }
    
    public ItemDaCompra buscar(final Integer itemCompraId) {
        return this.itemDaCompraRepositorio.findById(itemCompraId).orElseThrow(() -> new ItemDaCompraNaoEncontradoException(itemCompraId));
    }
    
    @Transactional
    public ItemDaCompra salvar(final ItemDaCompra itemCompra) {
        itemCompra.setCompra(this.compraService.buscarOuFalhar(itemCompra.getCompra().getCodigo()));
        return this.itemDaCompraRepositorio.save(itemCompra);
    }
    
    public ItemDaCompra buscarOuFalhar(final Integer itemCompraId) {
        return this.itemDaCompraRepositorio.findById(itemCompraId).orElseThrow(() -> new ItemDaCompraNaoEncontradoException(itemCompraId));
    }
    
    @Transactional
    public void excluir(final Integer itemCompraId) {
        try {
            this.itemDaCompraRepositorio.deleteById(itemCompraId);
            this.itemDaCompraRepositorio.flush();
            
        } catch (final EmptyResultDataAccessException e) {
            throw new ItemDaCompraNaoEncontradoException(itemCompraId, e);
            
        } catch (final DataIntegrityViolationException e) {
            throw new EntidadeEmUsoException(String.format(MENSAGEM_ITEM_DE_COMPRA_EM_USO, itemCompraId, e));
        }
        
    }
    
}
