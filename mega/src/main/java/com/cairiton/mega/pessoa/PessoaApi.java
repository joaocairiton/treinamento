package com.cairiton.mega.pessoa;

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

import com.cairiton.mega.endereco.EnderecoNaoEncontradoException;
import com.cairiton.mega.exception.NegocioException;
import com.cairiton.mega.profissao.ProfissaoNaoEncontradoException;

@RestController
@RequestMapping("/pessoa")
public class PessoaApi {
    
    @Autowired
    private PessoaService pessoaService;
    
    @Autowired
    private PessoaDtoConfig pessoaDtoConfig;
    
    @GetMapping
    public List<Pessoa> listaDePessoa() {
        return this.pessoaService.listarTodos();
    }
    
    @GetMapping(value = "/imprimir-todos", produces = {"application/pdf"})
    public ResponseEntity<byte[]> imprimirTodos() {
        return new ResponseEntity<>(this.pessoaService.imprimirTodos(), HttpStatus.OK);
    }
    
    @GetMapping("/{pessoaId}")
    public PessoaDto buscarPessoa(@PathVariable final Integer pessoaId, final Pessoa pessoa) {
        return this.pessoaDtoConfig.toModel(this.pessoaService.buscarOuFalhar(pessoaId));
    }
    
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public PessoaDto adicionar(@Valid @RequestBody final Pessoa pessoa) {
        try {
            return this.pessoaDtoConfig.toModel(this.pessoaService.salvar(pessoa));
            
        } catch (ProfissaoNaoEncontradoException | EnderecoNaoEncontradoException e) {
            throw new NegocioException(e.getMessage(), e);
        }
    }
    
    @PutMapping("/{pessoaId}")
    public PessoaDto atualizar(@PathVariable final Integer pessoaId, @RequestBody @Valid final Pessoa pessoa) {
        try {
            BeanUtils.copyProperties(pessoa, this.pessoaService.buscarOuFalhar(pessoaId), "codigo");
            return this.pessoaDtoConfig.toModel(this.pessoaService.salvar(this.pessoaService.buscarOuFalhar(pessoaId)));
            
        } catch (ProfissaoNaoEncontradoException | EnderecoNaoEncontradoException e) {
            throw new NegocioException(e.getMessage(), e);
        }
        
    }
    
    @DeleteMapping("/{pessoaId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void remover(@PathVariable final Integer pessoaId) {
        this.pessoaService.excluir(pessoaId);
        
    }
    
}
