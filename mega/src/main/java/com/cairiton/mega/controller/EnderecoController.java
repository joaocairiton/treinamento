package com.cairiton.mega.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cairiton.mega.model.Endereco;
import com.cairiton.mega.repository.EnderecoRepository;
import com.cairiton.mega.service.EnderecoConfigService;

@RestController
@RequestMapping("/enderecos")
public class EnderecoController {

	@Autowired
	private EnderecoRepository enderecoRepository;

	@Autowired
	private EnderecoConfigService enderecoConfigService;

	@GetMapping
	public List<Endereco> listaDeBairro() {
		return enderecoRepository.findAll();
	}

	@GetMapping("/{enderecoId}")
	public ResponseEntity<Endereco> buscarEndereco(@PathVariable Integer enderecoId) {
		return enderecoRepository.findById(enderecoId).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
	}

	@PostMapping
	public Endereco adicionar(@Valid @RequestBody Endereco endereco) {
		return enderecoConfigService.salvar(endereco);
	}

	@DeleteMapping("/{enderecoId}")
	public ResponseEntity<Void> remover(@PathVariable Integer enderecoId) {

		if (!enderecoRepository.existsById(enderecoId)) {
			return ResponseEntity.notFound().build();

		}

		enderecoConfigService.excluir(enderecoId);
		return ResponseEntity.noContent().build();
	}

}
