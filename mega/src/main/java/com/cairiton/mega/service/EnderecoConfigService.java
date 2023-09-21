package com.cairiton.mega.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cairiton.mega.exception.NegocioException;
import com.cairiton.mega.model.Bairro;
import com.cairiton.mega.model.Endereco;
import com.cairiton.mega.repository.EnderecoRepository;

@Service
public class EnderecoConfigService {
	
	@Autowired
	private EnderecoRepository enderecoRepository;
	
	@Autowired
	private BairroConfigService bairroConfigService;
	

	public Endereco buscar (Integer enderecoId) {
		return enderecoRepository.findById(enderecoId).orElseThrow(() -> new NegocioException("Endereco não encontrado! "));
	}
	
	
	@Transactional
	public Endereco salvar(Endereco endereco) {
		
		Bairro bairro = bairroConfigService.buscar(endereco.getBairro().getCodigo());
		
		endereco.setBairro(bairro);

		return enderecoRepository.save(endereco);
	}
	
	@Transactional
	public void excluir(Integer bairroId) {
		enderecoRepository.deleteById(bairroId);
		
	}
	
	

}
