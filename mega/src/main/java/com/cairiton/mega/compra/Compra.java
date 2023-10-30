package com.cairiton.mega.compra;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.cairiton.mega.itemdacompra.ItemDaCompra;
import com.cairiton.mega.pessoa.Pessoa;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

@Entity
@Table(name = "compra")
public class Compra {
    
    @Id
    @Column(name = "codigo")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer codigo;
    
    @Column(name = "valor_total")
    private BigDecimal valorTotal;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "codigo_da_pessoa")
    @JsonProperty(access = Access.WRITE_ONLY)
    private Pessoa pessoa;
    
    @OneToMany(mappedBy = "compra", fetch = FetchType.LAZY)
    @JsonProperty(access = Access.WRITE_ONLY)
    private List<ItemDaCompra> itensDaCompra = new ArrayList<>();
    
    public Compra() {}
    
    public Compra(final Integer codigo,
            @NotNull final BigDecimal valorTotal,
            final Pessoa pessoa,
            final List<ItemDaCompra> itensDaCompra) {
        super();
        this.codigo = codigo;
        this.valorTotal = valorTotal;
        this.pessoa = pessoa;
        this.itensDaCompra = itensDaCompra;
    }
    
    public Integer getCodigo() {
        return this.codigo;
    }
    
    public void setCodigo(final Integer codigo) {
        this.codigo = codigo;
    }
    
    public BigDecimal getValorTotal() {
        BigDecimal amount = BigDecimal.valueOf(0.0);
        for (final ItemDaCompra item : this.itensDaCompra) {
            amount = amount.add(item.getValor().multiply(new BigDecimal(1)));
        }
        return amount;
    }
    
    public void setValorTotal(final BigDecimal valorTotal) {
        this.valorTotal = valorTotal;
    }
    
    public Pessoa getPessoa() {
        return this.pessoa;
    }
    
    public void setPessoa(final Pessoa pessoa) {
        this.pessoa = pessoa;
    }
    
    public List<ItemDaCompra> getItensDaCompra() {
        return this.itensDaCompra;
    }
    
    public void setItensDaCompra(final List<ItemDaCompra> itensDaCompra) {
        this.itensDaCompra = itensDaCompra;
    }
    
}
