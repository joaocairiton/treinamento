package com.cairiton.mega.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cairiton.mega.model.ItemCompra;
import com.cairiton.mega.repository.ItemCompraRepository;
import com.cairiton.mega.service.ItemCompraConfigService;

@RestController
@RequestMapping("/item-compras")
public class ItemCompraController {
	
	@Autowired
	private ItemCompraRepository itemCompraRepository;
	
	@Autowired
	private ItemCompraConfigService itemCompraConfigService;
	
	@GetMapping
	public List<ItemCompra> listaDeItemCompra() {
		return itemCompraRepository.findAll();
	}
	
	@GetMapping("/{itemCompraId}")
	public ResponseEntity<ItemCompra> buscarItemCompra(@PathVariable Integer itemCompraId) {
		return itemCompraRepository.findById(itemCompraId).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
	}
	
	@PostMapping
	public ItemCompra adicionar(@Valid @RequestBody ItemCompra itemCompra) {
		return itemCompraConfigService.salvar(itemCompra);
	}

}
