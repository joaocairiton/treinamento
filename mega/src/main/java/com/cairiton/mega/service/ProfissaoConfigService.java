package com.cairiton.mega.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cairiton.mega.exception.NegocioException;
import com.cairiton.mega.exception.ProfissaoNaoEncontradoException;
import com.cairiton.mega.model.Profissao;
import com.cairiton.mega.repository.ProfissaoRepository;

@Service
public class ProfissaoConfigService {

	@Autowired
	private ProfissaoRepository profissaoRepository;
	
	public Profissao buscar(Integer profissaoId) {
		return profissaoRepository.findById(profissaoId).orElseThrow(() -> new NegocioException("Profissao não encontrado!"));
	}

	@Transactional
	public Profissao salvar(Profissao profissao) {

		return profissaoRepository.save(profissao);
	}
	
	@Transactional
	public void excluir(Integer profissaoId) {
		profissaoRepository.deleteById(profissaoId);
		
	}
	
	public Profissao buscarOuFalhar(Integer profissaoId) {
		return profissaoRepository.findById(profissaoId).orElseThrow(() -> new ProfissaoNaoEncontradoException(profissaoId));
	}
	

}
