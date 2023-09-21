package com.cairiton.mega.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cairiton.mega.model.Profissao;
import com.cairiton.mega.repository.ProfissaoRepository;

@Service
public class ProfissaoConfigService {

	@Autowired
	private ProfissaoRepository profissaoRepository;

	@Transactional
	public Profissao salvar(Profissao profissao) {

		return profissaoRepository.save(profissao);
	}
	
	@Transactional
	public void excluir(Integer profissaoId) {
		profissaoRepository.deleteById(profissaoId);
		
	}

}
