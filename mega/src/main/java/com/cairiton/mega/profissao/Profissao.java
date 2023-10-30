package com.cairiton.mega.profissao;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "profissao")
public class Profissao {
    
    @Id
    @Column(name = "codigo")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer codigo;
    
    @NotBlank
    @Size(max = 60)
    @Column(name = "nome")
    private String nome;
    
    @NotNull
    @Column(name = "salario")
    private BigDecimal salario;
    
    public Profissao() {}
    
    public Profissao(final Integer codigo, @NotBlank @Size(max = 60) final String nome, @NotNull final BigDecimal salario) {
        super();
        this.codigo = codigo;
        this.nome = nome;
        this.salario = salario;
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
    
    public BigDecimal getSalario() {
        return this.salario;
    }
    
    public void setSalario(final BigDecimal salario) {
        this.salario = salario;
    }
    
}
