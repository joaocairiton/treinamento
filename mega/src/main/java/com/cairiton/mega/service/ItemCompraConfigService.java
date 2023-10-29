package com.cairiton.mega.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cairiton.mega.exception.ItemCompraNaoEncontradoException;
import com.cairiton.mega.exception.NegocioException;
import com.cairiton.mega.model.Compra;
import com.cairiton.mega.model.ItemCompra;
import com.cairiton.mega.repository.ItemCompraRepository;

@Service
public class ItemCompraConfigService {
	
	
	@Autowired
	private ItemCompraRepository itemCompraRepository;
	
	@Autowired
	private CompraConfigService compraConfigService;
	
	
	
	
	public ItemCompra buscar (Integer itemCompraId) {
		return itemCompraRepository.findById(itemCompraId).orElseThrow(() -> new NegocioException("Item-compra não encontrado! "));
	}
	
	
	@Transactional
	public ItemCompra salvar(ItemCompra itemCompra) {
		
		Compra compra = compraConfigService.buscar(itemCompra.getCompra().getCodigo());
		
		itemCompra.setCompra(compra);

		return itemCompraRepository.save(itemCompra);
	}
	
	public ItemCompra buscarOuFalhar(Integer itemCompraId) {
		return itemCompraRepository.findById(itemCompraId).orElseThrow(() -> new ItemCompraNaoEncontradoException(itemCompraId));
	}

}
