package com.cairiton.mega.itemdacompra;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.cairiton.mega.compra.Compra;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

@Entity
@Table(name = "item_compra")
public class ItemDaCompra {
    
    @Id
    @Column(name = "codigo")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer codigo;
    
    @NotBlank
    @Size(max = 60)
    @Column(name = "nome")
    private String nome;
    
    @NotNull
    @Column(name = "valor")
    private BigDecimal valor;
    
    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "codigo_da_compra")
    @JsonProperty(access = Access.WRITE_ONLY)
    private Compra compra;
    
    public ItemDaCompra() {}
    
    public ItemDaCompra(final Integer codigo, @NotBlank @Size(max = 60) final String nome, @NotNull final BigDecimal valor,
            @NotNull final Compra compra) {
        super();
        this.codigo = codigo;
        this.nome = nome;
        this.valor = valor;
        this.compra = compra;
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
    
    public BigDecimal getValor() {
        return this.valor;
    }
    
    public void setValor(final BigDecimal valor) {
        this.valor = valor;
    }
    
    public Compra getCompra() {
        return this.compra;
    }
    
    public void setCompra(final Compra compra) {
        this.compra = compra;
    }
    
}
