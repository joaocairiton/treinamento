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

import com.cairiton.mega.model.Compra;
import com.cairiton.mega.repository.CompraRepository;
import com.cairiton.mega.service.CompraConfigService;

@RestController
@RequestMapping("/compras")
public class CompraController {
	
	
	@Autowired
	private CompraRepository compraRepository;
	
	@Autowired
	private CompraConfigService compraConfigService;
	
	@GetMapping
	public List<Compra> listaDeCompra() {
		return compraRepository.findAll();
	}
	
	@GetMapping("/{compraId}")
	public ResponseEntity<Compra> buscarCompra(@PathVariable Integer compraId) {
		return compraRepository.findById(compraId).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Compra adicionar(@Valid @RequestBody Compra compra) {
		return compraConfigService.salvar(compra);
	}


}
