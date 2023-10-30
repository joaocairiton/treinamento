package com.cairiton.mega.bairro;

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
@Table(name = "bairro")
public class Bairro {
    
    @Id
    @Column(name = "codigo")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer codigo;
    
    @NotBlank
    @Size(max = 60)
    @Column(name = "nome")
    private String nome;
    
    @NotNull
    @Column(name = "valor_do_iptu")
    private BigDecimal valorDoIptu;
    
    public Bairro() {
        
    }
    
    public Bairro(final Integer codigo,
            @NotBlank @Size(max = 60) final String nome,
            @NotNull final BigDecimal valorDoIptu) {
        super();
        this.codigo = codigo;
        this.nome = nome;
        this.valorDoIptu = valorDoIptu;
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
    
    public BigDecimal getValorDoIptu() {
        return this.valorDoIptu;
    }
    
    public void setValorDoIptu(final BigDecimal valorDoIptu) {
        this.valorDoIptu = valorDoIptu;
    }
    
}
