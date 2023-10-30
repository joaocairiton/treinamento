package com.cairiton.mega.bairro;

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
@RequestMapping("/bairro")
public class BairroApi {
    
    @Autowired
    private BairroRepositorio bairroRepositorio;
    
    @Autowired
    private BairroService bairroService;
    
    @Autowired
    private BairroDtoConfig bairroDtoConfig;
    
    @GetMapping
    public List<BairroDto> listarTodoOsBairros() {
        return this.bairroDtoConfig.toCollectionModel(this.bairroRepositorio.findAll());
    }
    
    @GetMapping("/{bairroId}")
    public BairroDto buscarBairro(@PathVariable final Integer bairroId) {
        return this.bairroDtoConfig.toModel(this.bairroService.buscarOuFalhar(bairroId));
    }
    
    @GetMapping(value = "/imprimir-todos", produces = {"application/pdf"})
    ResponseEntity<byte[]> imprimirTodos() {
        return new ResponseEntity<>(this.bairroService.imprimirTodos(), HttpStatus.OK);
    }
    
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public BairroDto adicionar(@RequestBody @Valid final Bairro bairro) {
        return this.bairroDtoConfig.toModel(this.bairroService.salvar(bairro));
    }
    
    @PutMapping("/{bairroId}")
    public BairroDto atualizar(@PathVariable final Integer bairroId, @RequestBody @Valid final Bairro bairro) {
        BeanUtils.copyProperties(bairro, this.bairroService.buscarOuFalhar(bairroId), "codigo");
        return this.bairroDtoConfig.toModel(this.bairroService.salvar(this.bairroService.buscarOuFalhar(bairroId)));
    }
    
    @DeleteMapping("/{bairroId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void remover(@PathVariable final Integer bairroId) {
        this.bairroService.excluir(bairroId);
    }
}
