package com.cairiton.mega.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cairiton.mega.exception.NegocioException;
import com.cairiton.mega.model.Compra;
import com.cairiton.mega.model.Pessoa;
import com.cairiton.mega.repository.CompraRepository;

@Service
public class CompraConfigService {

	@Autowired
	private CompraRepository compraRepository;

	@Autowired
	private PessoaConfigService pessoaConfigService;
	
	
	public Compra buscar (Integer compraId) {
		return compraRepository.findById(compraId).orElseThrow(() -> new NegocioException("Compra não encontrada!"));
	}

	@Transactional
	public Compra salvar(Compra compra) {

		Pessoa pessoa = pessoaConfigService.buscar(compra.getPessoa().getCodigo());

		compra.setPessoa(pessoa);

		return compraRepository.save(compra);
	}

}
