package com.cairiton.mega.bairro;

import java.math.BigDecimal;

public class BairroDto {
    
    private Integer codigo;
    
    private String nome;
    
    private BigDecimal valorDoIptu;
    
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
