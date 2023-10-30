package com.cairiton.mega.endereco;

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

import com.cairiton.mega.bairro.BairroNaoEncontradoException;
import com.cairiton.mega.exception.NegocioException;

@RestController
@RequestMapping("/endereco")
public class EnderecoApi {
    
    @Autowired
    private EnderecoRepositorio enderecoRepositorio;
    
    @Autowired
    private EnderecoService enderecoService;
    
    @Autowired
    private EnderecoDtoConfig enderecoDtoConfig;
    
    @GetMapping
    public List<EnderecoDto> listaDeEndereco() {
        return this.enderecoDtoConfig.toCollectionModel(this.enderecoRepositorio.findAll());
    }
    
    @GetMapping(value = "/imprimir-todos", produces = {"application/pdf"})
    ResponseEntity<byte[]> imprimirTodos() {
        return new ResponseEntity<>(this.enderecoService.imprimirTodos(), HttpStatus.OK);
    }
    
    @GetMapping("/{enderecoId}")
    public EnderecoDto buscar(@PathVariable final Integer enderecoId) {
        return this.enderecoDtoConfig.toModel(this.enderecoService.buscarOuFalhar(enderecoId));
    }
    
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public EnderecoDto adicionar(@RequestBody @Valid final Endereco endereco) {
        try {
            return this.enderecoDtoConfig.toModel(this.enderecoService.salvar(endereco));
        } catch (final BairroNaoEncontradoException e) {
            throw new NegocioException(e.getMessage(), e);
        }
    }
    
    @PutMapping("/{enderecoId}")
    public EnderecoDto atualizar(@PathVariable final Integer enderecoId, @RequestBody @Valid final Endereco endereco) {
        try {
            BeanUtils.copyProperties(endereco, this.enderecoService.buscarOuFalhar(enderecoId), "codigo");
            return this.enderecoDtoConfig.toModel(this.enderecoService.salvar(this.enderecoService.buscarOuFalhar(enderecoId)));
            
        } catch (final BairroNaoEncontradoException e) {
            throw new NegocioException(e.getMessage(), e);
        }
    }
    
    @DeleteMapping("/{enderecoId}")
    public void remover(@PathVariable final Integer enderecoId) {
        this.enderecoService.excluir(enderecoId);
    }
    
}
