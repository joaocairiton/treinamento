package com.cairiton.mega.compra;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cairiton.mega.exception.EntidadeEmUsoException;
import com.cairiton.mega.pessoa.PessoaService;
import com.cairiton.mega.relatorio.RelatorioUtil;

@Service
public class CompraService {
    
    private static final String MENSAGEM_COMPRA_EM_USO = "Compra de código %d não pode ser removido, pois está em uso";
    
    @Autowired
    private CompraRepositorio compraRepository;
    
    @Autowired
    private PessoaService pessoaConfigService;
    
    public Compra buscarOuFalhar(final Integer compraId) {
        return this.compraRepository
                .findById(compraId)
                .orElseThrow(() -> new CompraNaoEncontradaException(compraId));
    }
    
    public byte[] imprimirTodos() {
        final Map<String, Object> parametros = new HashMap<>();
        parametros.put("TITULO", "megasoft");
        return RelatorioUtil.gerarPdf(parametros, this.compraRepository.findAll(), this.getClass().getResourceAsStream("/relatorios/relatorio-de-compras/relatorio-de-compra.jasper"));
    }
    
    @Transactional
    public Compra salvar(final Compra compra) {
        compra.setPessoa(this.pessoaConfigService.buscarOuFalhar(compra.getPessoa().getCodigo()));
        return this.compraRepository.save(compra);
    }
    
    @Transactional
    public void excluir(final Integer compraId) {
        try {
            this.compraRepository.deleteById(compraId);
            this.compraRepository.flush();
            
        } catch (final EmptyResultDataAccessException e) {
            throw new CompraNaoEncontradaException(compraId, e);
            
        } catch (final DataIntegrityViolationException e) {
            throw new EntidadeEmUsoException(String.format(MENSAGEM_COMPRA_EM_USO, compraId, e));
        }
        
    }
    
}
