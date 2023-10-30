package com.cairiton.mega.endereco;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cairiton.mega.bairro.BairroService;
import com.cairiton.mega.exception.EntidadeEmUsoException;
import com.cairiton.mega.relatorio.RelatorioUtil;

@Service
public class EnderecoService {
    
    private static final String MENSAGEM_ENDERECO_EM_USO = "Endereco de código %d não pode ser removido, pois está em uso";
    
    @Autowired
    private EnderecoRepositorio enderecoRepository;
    
    @Autowired
    private BairroService bairroConfigService;
    
    public Endereco buscarOuFalhar(final Integer enderecoId) {
        return this.enderecoRepository.findById(enderecoId).orElseThrow(() -> new EnderecoNaoEncontradoException(enderecoId));
    }
    
    @Transactional
    public Endereco salvar(final Endereco endereco) {
        endereco.setBairro(this.bairroConfigService.buscarOuFalhar(endereco.getBairro().getCodigo()));
        return this.enderecoRepository.save(endereco);
    }
    
    public byte[] imprimirTodos() {
        final Map<String, Object> parametros = new HashMap<>();
        parametros.put("TITULO", "megasoft");
        return RelatorioUtil.gerarPdf(parametros, this.enderecoRepository.findAll(), this.getClass().getResourceAsStream("/relatorios/relatorio-de-endereco/relatorio-de-endereco.jasper"));
    }
    
    @Transactional
    public void excluir(final Integer enderecoId) {
        try {
            this.enderecoRepository.deleteById(enderecoId);
            this.enderecoRepository.flush();
            
        } catch (final EmptyResultDataAccessException e) {
            throw new EnderecoNaoEncontradoException(enderecoId, e);
            
        } catch (final DataIntegrityViolationException e) {
            throw new EntidadeEmUsoException(String.format(MENSAGEM_ENDERECO_EM_USO, enderecoId, e));
        }
    }
    
}
