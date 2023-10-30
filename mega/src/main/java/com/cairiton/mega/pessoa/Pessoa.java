package com.cairiton.mega.pessoa;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.ConstraintMode;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.cairiton.mega.endereco.Endereco;
import com.cairiton.mega.profissao.Profissao;
import com.cairiton.mega.validador.ValidaCpf;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

@Entity
@Table(name = "pessoa")
public class Pessoa {
    
    @Id
    @Column(name = "codigo")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer codigo;
    
    @NotBlank
    @Column(name = "nome")
    private String nome;
    
    @NotNull
    @Column(name = "data_de_nascimento")
    private LocalDate dataDeNascimento;
    
    @NotBlank
    @Column(name = "genero")
    private String genero;
    
    @NotBlank
    @Column(name = "Portador_de_necessidade_especiais")
    private String portadorDeNecessidadeEspeciais;
    
    @NotNull
    @Column(name = "altura")
    private BigDecimal altura;
    
    @NotNull
    @Column(name = "peso")
    private BigDecimal peso;
    
    @NotBlank
    @ValidaCpf
    @Column(name = "cpf")
    private String cpf;
    
    @NotBlank
    @Column(name = "tipo_de_pessoa")
    private String tipoDePessoa;
    
    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "codigo_do_endereco")
    @JsonProperty(access = Access.WRITE_ONLY)
    private Endereco endereco;
    
    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "codigo_da_profissao", foreignKey = @ForeignKey(ConstraintMode.NO_CONSTRAINT))
    @JsonProperty(access = Access.WRITE_ONLY)
    private Profissao profissao;
    
    public Pessoa() {}
    
    public Pessoa(final Integer codigo, @NotBlank final String nome, @NotNull final LocalDate dataDeNascimento, @NotBlank final String genero, @NotBlank final String portadorDeNecessidadeEspeciais,
            @NotNull final BigDecimal altura,
            @NotNull final BigDecimal peso, @NotBlank final String cpf, @NotBlank final String tipoDePessoa, @NotNull final Endereco endereco, @NotNull final Profissao profissao) {
        super();
        this.codigo = codigo;
        this.nome = nome;
        this.dataDeNascimento = dataDeNascimento;
        this.genero = genero;
        this.portadorDeNecessidadeEspeciais = portadorDeNecessidadeEspeciais;
        this.altura = altura;
        this.peso = peso;
        this.cpf = cpf;
        this.tipoDePessoa = tipoDePessoa;
        this.endereco = endereco;
        this.profissao = profissao;
    }
    
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
    
    public Endereco getEndereco() {
        return this.endereco;
    }
    
    public void setEndereco(final Endereco endereco) {
        this.endereco = endereco;
    }
    
    public Profissao getProfissao() {
        return this.profissao;
    }
    
    public void setProfissao(final Profissao profissao) {
        this.profissao = profissao;
    }
    
}
