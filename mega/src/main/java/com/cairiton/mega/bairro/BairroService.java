package com.cairiton.mega.bairro;

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
public class BairroService {
    
    private static final String MENSAGEM_BAIRRO_EM_USO = "Bairro de código %d não pode ser removido, pois está em uso";
    
    @Autowired
    private BairroRepositorio bairroRepository;
    
    public Bairro buscarOuFalhar(final Integer bairroId) {
        return this.bairroRepository.findById(bairroId).orElseThrow(() -> new BairroNaoEncontradoException(bairroId));
    }
    
    @Transactional
    public Bairro salvar(final Bairro bairro) {
        return this.bairroRepository.save(bairro);
    }
    
    public byte[] imprimirTodos() {
        final Map<String, Object> parametros = new HashMap<>();
        parametros.put("TITULO", "megasoft");
        return RelatorioUtil.gerarPdf(parametros,
                this.bairroRepository.findAll(),
                this.getClass().getResourceAsStream("/relatorios/relatorio-de-bairros/lista-de-bairros.jasper"));
    }
    
    public void excluir(final Integer bairroId) {
        try {
            this.bairroRepository.deleteById(bairroId);
            
        } catch (final EmptyResultDataAccessException e) {
            throw new BairroNaoEncontradoException(bairroId, e);
            
        } catch (final DataIntegrityViolationException e) {
            throw new EntidadeEmUsoException(String.format(MENSAGEM_BAIRRO_EM_USO, bairroId, e));
        }
    }
    
}
