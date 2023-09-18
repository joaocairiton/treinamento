package com.cairiton.mega.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;


@Entity
public class Endereco {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer codigo_endereco;
	@NotBlank
	private String rua;
	@NotBlank
	private String numero;
	@NotBlank
	private String complemento;
	@NotBlank
	private String cep;
	
	@NotBlank
	@ManyToOne(fetch = FetchType.EAGER)
	private Bairro bairro;
	
	
	public Endereco() {
	}

	public Integer getCodigo_endereco() {
		return codigo_endereco;
	}

	public void setCodigo_endereco(Integer codigo_endereco) {
		this.codigo_endereco = codigo_endereco;
	}

	public String getRua() {
		return rua;
	}

	public void setRua(String rua) {
		this.rua = rua;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	
}
