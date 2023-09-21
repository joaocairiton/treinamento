package com.cairiton.mega.controller;

import java.util.List;

import javax.validation.Valid;

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

import com.cairiton.mega.model.Profissao;
import com.cairiton.mega.repository.ProfissaoRepository;
import com.cairiton.mega.service.ProfissaoConfigService;

@RestController
@RequestMapping("/profissoes")
public class ProfissaoController {
	
	@Autowired
	private ProfissaoRepository profissaoRepository;
	
	@Autowired
	private ProfissaoConfigService profissaoConfigService;
	
	@GetMapping
	public List<Profissao> listaDeProfissao() {
		return profissaoRepository.findAll();
	}
	
	@GetMapping("/{profissaoId}")
	public ResponseEntity<Profissao> buscarProfissao(@PathVariable Integer profissaoId) {
		return profissaoRepository.findById(profissaoId).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Profissao adicionar(@Valid @RequestBody Profissao profissao) {
		return profissaoConfigService.salvar(profissao);
	}
	
	@PutMapping("/{profissaoId}")
	public ResponseEntity<Profissao> atualizar(@PathVariable Integer profissaoId, @Valid @RequestBody Profissao profissao) {

		if (!profissaoRepository.existsById(profissaoId)) {
			return ResponseEntity.notFound().build();

		}

		profissao.setCodigo(profissaoId);
		profissao = profissaoConfigService.salvar(profissao);

		return ResponseEntity.ok(profissao);
	}
	
	@DeleteMapping("/{profissaoId}")
	public ResponseEntity<Void> remover(@PathVariable Integer profissaoId) {

		if (!profissaoRepository.existsById(profissaoId)) {
			return ResponseEntity.notFound().build();

		}

		profissaoConfigService.excluir(profissaoId);
		return ResponseEntity.noContent().build();
	}

}
