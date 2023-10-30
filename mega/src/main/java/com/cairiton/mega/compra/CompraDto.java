package com.cairiton.mega.compra;

import java.math.BigDecimal;
import java.util.List;

import com.cairiton.mega.itemdacompra.ItemDaCompra;
import com.cairiton.mega.pessoa.PessoaDto;

public class CompraDto {
    
    private Integer codigo;
    
    private BigDecimal valorTotal;
    
    private PessoaDto pessoa;
    
    private List<ItemDaCompra> itensDaCompra;
    
    public List<ItemDaCompra> getItensDaCompra() {
        return itensDaCompra;
    }
    
    public void setItensDaCompra(List<ItemDaCompra> itensDaCompra) {
        this.itensDaCompra = itensDaCompra;
    }
    
    public Integer getCodigo() {
        return codigo;
    }
    
    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }
    
    public BigDecimal getValorTotal() {
        return valorTotal;
    }
    
    public void setValorTotal(BigDecimal valorTotal) {
        this.valorTotal = valorTotal;
    }
    
    public PessoaDto getPessoa() {
        return pessoa;
    }
    
    public void setPessoa(PessoaDto pessoa) {
        this.pessoa = pessoa;
    }
    
}
