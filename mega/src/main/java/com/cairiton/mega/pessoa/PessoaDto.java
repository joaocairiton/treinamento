package com.cairiton.mega.pessoa;

import java.math.BigDecimal;
import java.time.LocalDate;

import com.cairiton.mega.endereco.EnderecoDto;
import com.cairiton.mega.profissao.ProfissaoDto;

public class PessoaDto {
    
    private Integer codigo;
    
    private String nome;
    
    private LocalDate dataDeNascimento;
    
    private String genero;
    
    private String portadorDeNecessidadeEspeciais;
    
    private BigDecimal altura;
    
    private BigDecimal peso;
    
    private String cpf;
    
    private String tipoDePessoa;
    
    private EnderecoDto endereco;
    
    private ProfissaoDto profissao;
    
    public Integer getCodigo() {
        return this.codigo;
    }
    
    public void setCodigo(final Integer codigo) {
        this.codigo = codigo;
    }
    
    public String getNome() {
        return this.nome;
    }
    
    public void setNome(final String nome) {
        this.nome = nome;
    }
    
    public LocalDate getDataDeNascimento() {
        return this.dataDeNascimento;
    }
    
    public void setDataDeNascimento(final LocalDate dataDeNascimento) {
        this.dataDeNascimento = dataDeNascimento;
    }
    
    public String getGenero() {
        return this.genero;
    }
    
    public void setGenero(final String genero) {
        this.genero = genero;
    }
    
    public String getPortadorDeNecessidadeEspeciais() {
        return this.portadorDeNecessidadeEspeciais;
    }
    
    public void setPortadorDeNecessidadeEspeciais(final String portadorDeNecessidadeEspeciais) {
        this.portadorDeNecessidadeEspeciais = portadorDeNecessidadeEspeciais;
    }
    
    public BigDecimal getAltura() {
        return this.altura;
    }
    
    public void setAltura(final BigDecimal altura) {
        this.altura = altura;
    }
    
    public BigDecimal getPeso() {
        return this.peso;
    }
    
    public void setPeso(final BigDecimal peso) {
        this.peso = peso;
    }
    
    public String getCpf() {
        return this.cpf;
    }
    
    public void setCpf(final String cpf) {
        this.cpf = cpf;
    }
    
    public String getTipoDePessoa() {
        return this.tipoDePessoa;
    }
    
    public void setTipoDePessoa(final String tipoDePessoa) {
        this.tipoDePessoa = tipoDePessoa;
    }
    
    public EnderecoDto getEndereco() {
        return this.endereco;
    }
    
    public void setEndereco(final EnderecoDto endereco) {
        this.endereco = endereco;
    }
    
    public ProfissaoDto getProfissao() {
        return this.profissao;
    }
    
    public void setProfissao(final ProfissaoDto profissao) {
        this.profissao = profissao;
    }
    
}
