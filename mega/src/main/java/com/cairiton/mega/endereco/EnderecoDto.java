package com.cairiton.mega.endereco;

import com.cairiton.mega.bairro.BairroDto;

public class EnderecoDto {
    
    private Integer codigo;
    
    private String rua;
    
    private String numero;
    
    private String complemento;
    
    private String cep;
    
    private BairroDto bairro;
    
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
    
    public BairroDto getBairro() {
        return this.bairro;
    }
    
    public void setBairro(final BairroDto bairro) {
        this.bairro = bairro;
    }
    
}
