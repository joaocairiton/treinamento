package com.cairiton.mega.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cairiton.mega.exception.NegocioException;
import com.cairiton.mega.model.Endereco;
import com.cairiton.mega.model.Pessoa;
import com.cairiton.mega.repository.PessoaRepository;

@Service
public class PessoaConfigService {

	@Autowired
	private PessoaRepository pessoaRepository;

	@Autowired
	private EnderecoConfigService enderecoConfigService;

	public Pessoa buscar(Integer pessoaId) {
		return pessoaRepository.findById(pessoaId).orElseThrow(() -> new NegocioException("Pessoa não encontrado! "));
	}

	@Transactional
	public Pessoa salvar(Pessoa pessoa) {

		Endereco endereco = enderecoConfigService.buscar(pessoa.getEndereco().getCodigo());

		pessoa.setEndereco(endereco);

		boolean cpfEmUso = pessoaRepository.findByCpf(pessoa.getCpf()).stream()
				.anyMatch(cpfExistente -> !cpfExistente.equals(pessoa));
		if (cpfEmUso) {
			throw new NegocioException("Já existe um CPF cadastrado!");
		}

		return pessoaRepository.save(pessoa);
	}

}
