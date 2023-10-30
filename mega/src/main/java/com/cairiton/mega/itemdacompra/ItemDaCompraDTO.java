package com.cairiton.mega.itemdacompra;

import java.math.BigDecimal;

import com.cairiton.mega.compra.CompraDto;

public class ItemDaCompraDTO {
    
    private Integer codigo;
    
    private String nome;
    
    private BigDecimal valor;
    
    private CompraDto compra;
    
    public Integer getCodigo() {
        return codigo;
    }
    
    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }
    
    public String getNome() {
        return nome;
    }
    
    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public BigDecimal getValor() {
        return valor;
    }
    
    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }
    
    public CompraDto getCompra() {
        return compra;
    }
    
    public void setCompra(CompraDto compra) {
        this.compra = compra;
    }
    
}
