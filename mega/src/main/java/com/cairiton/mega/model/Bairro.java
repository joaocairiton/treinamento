package com.cairiton.mega.model;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.cairiton.mega.validation.ValidationGroups;
import com.cairiton.mega.validation.ValidationGroups.BairroId;




@Entity
public class Bairro {

	@NotNull(groups = ValidationGroups.BairroId.class)
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer codigo_bairro;
	@NotBlank
	@Size(max = 60)
	private String nome;
	



    @NotNull
	private BigDecimal valor_iptu;
	
	public Bairro() {
		
	}

	public Integer getCodigo_bairro() {
		return codigo_bairro;
	}

	public void setCodigo_bairro(Integer codigo_bairro) {
		this.codigo_bairro = codigo_bairro;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public BigDecimal getValor_iptu() {
		return valor_iptu;
	}

	public void setValor_iptu(BigDecimal valor_iptu) {
		this.valor_iptu = valor_iptu;
	}

	public Bairro(@NotNull(groups = BairroId.class) Integer codigo_bairro, @NotBlank @Size(max = 60) String nome,
			@NotNull BigDecimal valor_iptu) {
		super();
		this.codigo_bairro = codigo_bairro;
		this.nome = nome;
		this.valor_iptu = valor_iptu;
	}
	
	

	



	
	

	
	
	
	
	
}
