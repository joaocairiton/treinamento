package com.cairiton.mega.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cairiton.mega.exception.NegocioException;
import com.cairiton.mega.model.Endereco;
import com.cairiton.mega.repository.EnderecoRepository;

@Service
public class EnderecoConfigService {
	
	@Autowired
	private EnderecoRepository enderecoRepository;
	
	public Endereco buscar (Integer enderecoId) {
		return enderecoRepository.findById(enderecoId).orElseThrow(() -> new NegocioException("Bairro não encontrado! "));
	}
	
	
	@Transactional
	public Endereco salvar(Endereco endereco) {
		
		/*
		 * boolean bairroEmUso = bairroRepository.findByNome(bairro.getNome()) .stream()
		 * .anyMatch(bairroExistente -> !bairroExistente.equals(bairro)); if
		 * (bairroEmUso) { throw new
		 * NegocioException("Já existe um bairro cadastrado com esse Nome!"); }
		 */
		 
		
		return enderecoRepository.save(endereco);
	}
	
	@Transactional
	public void excluir(Integer bairroId) {
		enderecoRepository.deleteById(bairroId);
		
	}
	
	

}
