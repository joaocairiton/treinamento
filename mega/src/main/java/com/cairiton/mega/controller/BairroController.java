package com.cairiton.mega.controller;

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

import com.cairiton.mega.assembler.BairroModelAssembler;
import com.cairiton.mega.model.Bairro;
import com.cairiton.mega.repository.BairroRepository;
import com.cairiton.mega.service.BairroConfigService;

@RestController
@RequestMapping("/bairros")
public class BairroController {

	@Autowired
	private BairroRepository bairroRepository;

	@Autowired
	private BairroConfigService bairroConfigService;
	
	@Autowired
	private BairroModelAssembler bairroModelAssembler;

	@GetMapping
	public List<Bairro> listaDeBairro() {
		return bairroRepository.findAll();
	}

	@GetMapping("/{bairroId}")
	public Bairro buscarBairro(@PathVariable Integer bairroId) {
		Bairro bairro = bairroConfigService.buscarOuFalhar(bairroId);
		
		return bairroModelAssembler.toModel(bairro);
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Bairro adicionar(@Valid @RequestBody Bairro bairro) {
		return bairroConfigService.salvar(bairro);
	}
	
	
	@PutMapping("/{bairroId}")
	public Bairro atualizar(@PathVariable Integer bairroId,
			@RequestBody @Valid Bairro bairro) {
		Bairro bairroAtual = bairroConfigService.buscarOuFalhar(bairroId);
		
		BeanUtils.copyProperties(bairro, bairroAtual, "codigo");
		
		return bairroConfigService.salvar(bairroAtual);
	}

	
	
	@DeleteMapping("/{bairroId}")
	public ResponseEntity<Void> remover(@PathVariable Integer bairroId) {

		if (!bairroRepository.existsById(bairroId)) {
			return ResponseEntity.notFound().build();

		}

		bairroConfigService.excluir(bairroId);
		return ResponseEntity.noContent().build();
	}

}
