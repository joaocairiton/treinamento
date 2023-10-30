package com.cairiton.mega.exceptionhandler;

import java.time.OffsetDateTime;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
public class Problema {
    
    private Integer status;
    
    private OffsetDateTime dataHora;
    
    private String titulo;
    
    private List<Campo> campos;
    
    public Integer getStatus() {
        return this.status;
    }
    
    public void setStatus(final Integer status) {
        this.status = status;
    }
    
    public OffsetDateTime getDataHora() {
        return this.dataHora;
    }
    
    public void setDataHora(final OffsetDateTime dataHora) {
        this.dataHora = dataHora;
    }
    
    public String getTitulo() {
        return this.titulo;
    }
    
    public void setTitulo(final String titulo) {
        this.titulo = titulo;
    }
    
    public List<Campo> getCampos() {
        return this.campos;
    }
    
    public void setCampos(final List<Campo> campos) {
        this.campos = campos;
    }
    
    public static class Campo {
        
        private String nome;
        
        private String mensagem;
        
        public Campo() {}
        
        public Campo(final String nome, final String mensagem) {
            this.nome = nome;
            this.mensagem = mensagem;
        }
        
        public String getNome() {
            return this.nome;
        }
        
        public String getMensagem() {
            return this.mensagem;
        }
        
    }
    
}
