package com.cairiton.mega.profissao;

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

@RestController
@RequestMapping("/profissao")
public class ProfissaoApi {
    
    @Autowired
    private ProfissaoRepositorio profissaoRepositorio;
    
    @Autowired
    private ProfissaoService profissaoService;
    
    @Autowired
    private ProfissaoDtoConfig profissaoDtoConfig;
    
    @GetMapping
    public List<ProfissaoDto> listar() {
        return this.profissaoDtoConfig.toCollectionModel(this.profissaoRepositorio.findAll());
    }
    
    @GetMapping(value = "/imprimir-todos", produces = {"application/pdf"})
    ResponseEntity<byte[]> imprimirTodos() {
        return new ResponseEntity<>(this.profissaoService.imprimirTodos(), HttpStatus.OK);
    }
    
    @GetMapping("/{profissaoId}")
    public ProfissaoDto buscarProfissao(@PathVariable final Integer profissaoId) {
        return this.profissaoDtoConfig.toModel(this.profissaoService.buscarOuFalhar(profissaoId));
    }
    
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ProfissaoDto adicionar(@Valid @RequestBody final Profissao profissao) {
        return this.profissaoDtoConfig.toModel(this.profissaoService.salvar(profissao));
    }
    
    @PutMapping("/{profissaoId}")
    public ProfissaoDto atualizar(@PathVariable final Integer profissaoId, @RequestBody @Valid final Profissao profissao) {
        BeanUtils.copyProperties(profissao, this.profissaoService.buscarOuFalhar(profissaoId), "codigo");
        return this.profissaoDtoConfig.toModel(this.profissaoService.salvar(this.profissaoService.buscarOuFalhar(profissaoId)));
    }
    
    @DeleteMapping("/{profissaoId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void remover(@PathVariable final Integer profissaoId) {
        this.profissaoService.excluir(profissaoId);
        
    }
    
}
