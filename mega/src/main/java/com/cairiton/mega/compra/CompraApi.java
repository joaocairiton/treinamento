package com.cairiton.mega.compra;

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

import com.cairiton.mega.exception.NegocioException;
import com.cairiton.mega.pessoa.PessoaNaoEncontradoException;

@RestController
@RequestMapping("/compra")
public class CompraApi {
    
    @Autowired
    private CompraRepositorio compraRepositorio;
    
    @Autowired
    private CompraService compraService;
    
    @Autowired
    private CompraDtoConfig compraDtoConfig;
    
    @GetMapping
    public List<CompraDto> listaDeCompra() {
        return this.compraDtoConfig.toCollectionModel(this.compraRepositorio.findAll());
    }
    
    @GetMapping("/{compraId}")
    public CompraDto buscarCompra(@PathVariable final Integer compraId) {
        return this.compraDtoConfig.toModel(this.compraService.buscarOuFalhar(compraId));
    }
    
    @GetMapping(value = "/imprimir-todos", produces = {"application/pdf"})
    ResponseEntity<byte[]> imprimirTodos() {
        return new ResponseEntity<>(this.compraService.imprimirTodos(), HttpStatus.OK);
    }
    
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CompraDto adicionar(@Valid @RequestBody final Compra compra) {
        try {
            return this.compraDtoConfig.toModel(this.compraService.salvar(compra));
        } catch (final PessoaNaoEncontradoException e) {
            throw new NegocioException(e.getMessage(), e);
        }
    }
    
    @PutMapping("/{compraId}")
    public CompraDto atualizar(@PathVariable final Integer compraId, @RequestBody @Valid final Compra compra) {
        try {
            BeanUtils.copyProperties(compra, this.compraService.buscarOuFalhar(compraId), "codigo");
            return this.compraDtoConfig.toModel(this.compraService.buscarOuFalhar(compraId));
            
        } catch (final PessoaNaoEncontradoException e) {
            throw new NegocioException(e.getMessage(), e);
        }
    }
    
    @DeleteMapping("/{compraId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void remover(@PathVariable final Integer compraId) {
        this.compraService.excluir(compraId);
        
    }
    
}
