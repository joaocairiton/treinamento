package com.cairiton.mega.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.cairiton.mega.model.Pessoa;
import com.cairiton.mega.repository.PessoaRepository;
import com.cairiton.mega.service.PessoaConfigService;

@RestController
@RequestMapping("/pessoas")
public class PessoaController {

	@Autowired
	private PessoaRepository pessoaRepository;

	@Autowired
	private PessoaConfigService pessoaConfigService;

	@GetMapping
	public List<Pessoa> listaDePessoa() {
		return pessoaRepository.findAll();
	}

	@GetMapping("/{pessoaId}")
	public ResponseEntity<Pessoa> buscarPessoa(@PathVariable Integer pessoaId) {
		return pessoaRepository.findById(pessoaId).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Pessoa adicionar(@Valid @RequestBody Pessoa pessoa) {
		return pessoaConfigService.salvar(pessoa);
	}

}
