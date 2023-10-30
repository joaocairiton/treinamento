package com.cairiton.mega.pessoa;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cairiton.mega.endereco.EnderecoService;
import com.cairiton.mega.exception.EntidadeEmUsoException;
import com.cairiton.mega.exception.NegocioException;
import com.cairiton.mega.profissao.ProfissaoService;
import com.cairiton.mega.relatorio.RelatorioUtil;

@Service
public class PessoaService {
    
    private static final String MENSAGEM_PESSOA_EM_USO = "Pessoa de código %d não pode ser removido, pois está em uso";
    
    @Autowired
    private PessoaRepositorio pessoaRepositorio;
    
    @Autowired
    private EnderecoService enderecoService;
    
    @Autowired
    private ProfissaoService profissaoConfigService;
    
    public List<Pessoa> listarTodos() {
        return this.pessoaRepositorio.findAll();
    }
    
    public Pessoa buscarOuFalhar(final Integer pessoaId) {
        return this.pessoaRepositorio.findById(pessoaId).orElseThrow(() -> new PessoaNaoEncontradoException(pessoaId));
    }
    
    @Transactional
    public Pessoa salvar(final Pessoa pessoa) {
        
        pessoa.setProfissao(this.profissaoConfigService.buscarOuFalhar(pessoa.getProfissao().getCodigo()));
        pessoa.setEndereco(this.enderecoService.buscarOuFalhar(pessoa.getEndereco().getCodigo()));
        
        final boolean cpfEmUso = this.pessoaRepositorio.findByCpf(pessoa.getCpf()).stream()
                .anyMatch(cpfExistente -> !cpfExistente.equals(pessoa));
        if (cpfEmUso) {
            throw new NegocioException("Já existe um CPF cadastrado!");
        }
        
        return this.pessoaRepositorio.save(pessoa);
    }
    
    public byte[] imprimirTodos() {
        final Map<String, Object> parametros = new HashMap<>();
        parametros.put("TITULO", "megasoft");
        return RelatorioUtil.gerarPdf(parametros, this.pessoaRepositorio.findAll(), this.getClass().getResourceAsStream("/relatorios/relatorios-de-pessoas/relatorio-de-pessoa.jasper"));
    }
    
    @Transactional
    public void excluir(final Integer pessoaId) {
        try {
            this.pessoaRepositorio.deleteById(pessoaId);
            this.pessoaRepositorio.flush();
            
        } catch (final EmptyResultDataAccessException e) {
            throw new PessoaNaoEncontradoException(pessoaId, e);
            
        } catch (final DataIntegrityViolationException e) {
            throw new EntidadeEmUsoException(String.format(MENSAGEM_PESSOA_EM_USO, pessoaId, e));
        }
        
    }
    
}
