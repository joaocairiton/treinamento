package com.cairiton.mega.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cairiton.mega.exception.NegocioException;
import com.cairiton.mega.model.Bairro;
import com.cairiton.mega.repository.BairroRepository;

@Service
public class BairroConfigService {
	
	@Autowired
	private BairroRepository bairroRepository;
	
	public Bairro buscar (Integer bairroId) {
		return bairroRepository.findById(bairroId).orElseThrow(() -> new NegocioException("Bairro não encontrado! "));
	}
	
	
	@Transactional
	public Bairro salvar(Bairro bairro) {
		
		/*
		 * boolean bairroEmUso = bairroRepository.findByNome(bairro.getNome()) .stream()
		 * .anyMatch(bairroExistente -> !bairroExistente.equals(bairro)); if
		 * (bairroEmUso) { throw new
		 * NegocioException("Já existe um bairro cadastrado com esse Nome!"); }
		 */
		 
		
		return bairroRepository.save(bairro);
	}
	
	@Transactional
	public void excluir(Integer bairroId) {
		bairroRepository.deleteById(bairroId);
		
	}
	
	

}
