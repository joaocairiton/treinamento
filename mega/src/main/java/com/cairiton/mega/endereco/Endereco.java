package com.cairiton.mega.endereco;

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

import com.cairiton.mega.bairro.Bairro;
import com.cairiton.mega.validador.ValidaCep;

@Entity
@Table(name = "endereco")
public class Endereco {
    
    @Id
    @Column(name = "codigo")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer codigo;
    
    @NotBlank
    @Column(name = "rua")
    private String rua;
    
    @NotBlank
    @Column(name = "numero")
    private String numero;
    
    @NotBlank
    @Column(name = "complemento")
    private String complemento;
    
    @NotBlank
    @ValidaCep
    @Column(name = "cep")
    private String cep;
    
    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "codigo_do_bairro", nullable = false)
    private Bairro bairro;
    
    public Endereco() {}
    
    public Endereco(final Integer codigo,
            @NotBlank final String rua,
            @NotBlank final String numero,
            @NotBlank final String complemento,
            @NotBlank final String cep,
            @NotNull final Bairro bairro) {
        this.codigo = codigo;
        this.rua = rua;
        this.numero = numero;
        this.complemento = complemento;
        this.cep = cep;
        this.bairro = bairro;
    }
    
    public Integer getCodigo() {
        return this.codigo;
    }
    
    public void setCodigo(final Integer codigo) {
        this.codigo = codigo;
    }
    
    public String getRua() {
        return this.rua;
    }
    
    public void setRua(final String rua) {
        this.rua = rua;
    }
    
    public String getNumero() {
        return this.numero;
    }
    
    public void setNumero(final String numero) {
        this.numero = numero;
    }
    
    public String getComplemento() {
        return this.complemento;
    }
    
    public void setComplemento(final String complemento) {
        this.complemento = complemento;
    }
    
    public String getCep() {
        return this.cep;
    }
    
    public void setCep(final String cep) {
        this.cep = cep;
    }
    
    public Bairro getBairro() {
        return this.bairro;
    }
    
    public void setBairro(final Bairro bairro) {
        this.bairro = bairro;
    }
    
}
