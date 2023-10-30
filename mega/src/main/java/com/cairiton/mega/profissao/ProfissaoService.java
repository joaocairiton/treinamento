package com.cairiton.mega.profissao;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cairiton.mega.exception.EntidadeEmUsoException;
import com.cairiton.mega.relatorio.RelatorioUtil;

@Service
public class ProfissaoService {
    
    private static final String MENSAGEM_PROFISSAO_EM_USO = "Profissão de código %d não pode ser removido, pois está em uso";
    
    @Autowired
    private ProfissaoRepositorio profissaoRepositorio;
    
    @Transactional
    public Profissao buscarOuFalhar(final Integer profissaoId) {
        // return this.profissaoRepositorio.findById(profissaoId).orElseThrow(() -> new ProfissaoNaoEncontradoException(profissaoId));
        
        try {
            this.profissaoRepositorio.getReferenceById(profissaoId);
            
        } catch (final Exception e) {
            new ProfissaoNaoEncontradoException(profissaoId);
        }
        return this.profissaoRepositorio.getReferenceById(profissaoId);
        
    }
    
    @Transactional
    public Profissao salvar(final Profissao profissao) {
        return this.profissaoRepositorio.save(profissao);
    }
    
    public byte[] imprimirTodos() {
        final Map<String, Object> parametros = new HashMap<>();
        parametros.put("TITULO", "megasoft");
        return RelatorioUtil.gerarPdf(parametros, this.profissaoRepositorio.findAll(), this.getClass().getResourceAsStream("/relatorios/relatorio-de-profissao/lista-de-profissao.jasper"));
    }
    
    @Transactional
    public void excluir(final Integer profissaoId) {
        try {
            this.profissaoRepositorio.deleteById(profissaoId);
            this.profissaoRepositorio.flush();
            
        } catch (final EmptyResultDataAccessException e) {
            throw new ProfissaoNaoEncontradoException(profissaoId, e);
            
        } catch (final DataIntegrityViolationException e) {
            throw new EntidadeEmUsoException(String.format(MENSAGEM_PROFISSAO_EM_USO, profissaoId, e));
        }
        
    }
    
}
