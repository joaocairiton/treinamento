package com.cairiton.mega.itemdacompra;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.cairiton.mega.compra.CompraNaoEncontradaException;
import com.cairiton.mega.exception.NegocioException;

@RestController
@RequestMapping("/item-compra")
public class ItemDaCompraApi {
    
    @Autowired
    private ItemDaCompraRepositorio itemCompraRepository;
    
    @Autowired
    private ItemDaCompraService itemDaCompraService;
    
    @Autowired
    private ItemDaCompraDtoConfig itemDeCompraDtoConfig;
    
    @GetMapping(value = "/imprimir-todos", produces = {"application/pdf"})
    ResponseEntity<byte[]> imprimirTodos() {
        return new ResponseEntity<>(this.itemDaCompraService.imprimirTodos(), HttpStatus.OK);
    }
    
    @GetMapping
    public List<ItemDaCompraDTO> listaDeItemCompra() {
        return this.itemDeCompraDtoConfig.toCollectionModel(this.itemCompraRepository.findAll());
    }
    
    @GetMapping("/{itemCompraId}")
    public ItemDaCompraDTO buscaritemCompra(@PathVariable final Integer itemCompraId) {
        return this.itemDeCompraDtoConfig.toModel(this.itemDaCompraService.buscarOuFalhar(itemCompraId));
    }
    
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ItemDaCompraDTO adicionar(@Valid @RequestBody final ItemDaCompra itemCompra) {
        try {
            return this.itemDeCompraDtoConfig.toModel(this.itemDaCompraService.salvar(itemCompra));
            
        } catch (final CompraNaoEncontradaException e) {
            throw new NegocioException(e.getMessage(), e);
        }
    }
    
    @PutMapping("/{itemCompraId}")
    public ItemDaCompraDTO atualizar(@PathVariable final Integer itemCompraId, @RequestBody @Valid final ItemDaCompra itemCompra) {
        try {
            BeanUtils.copyProperties(itemCompra, this.itemDaCompraService.buscarOuFalhar(itemCompraId), "codigo");
            return this.itemDeCompraDtoConfig.toModel(this.itemDaCompraService.salvar(this.itemDaCompraService.buscarOuFalhar(itemCompraId)));
            
        } catch (final CompraNaoEncontradaException e) {
            throw new NegocioException(e.getMessage(), e);
        }
        
    }
    
    @DeleteMapping("/{itemCompraId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void remover(@PathVariable final Integer itemCompraId) {
        this.itemDaCompraService.excluir(itemCompraId);
        
    }
    
}
