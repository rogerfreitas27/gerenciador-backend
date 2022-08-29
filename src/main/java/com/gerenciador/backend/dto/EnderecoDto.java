package com.gerenciador.backend.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class EnderecoDto {
	@NotBlank(message="Campo Obrigatório")
	@Size(min = 3, max=255,message="campo com no mínimo 3 e no máximo de 255 caracteres.")
    private String logradouro;
	
	@NotBlank(message="Campo Obrigatório")
	@Size(min = 8, max=8,message="campo com 8  caracteres.")
    private String cep;	
	
	private Integer numero;
	
	@NotBlank(message="Campo Obrigatório")
	@Size(min = 3, max=255,message="campo com no mínimo 3 e no máximo de 255 caracteres.")
    private String cidade;
	
	@NotNull(message="Campo Obrigatório")
    private Boolean principal;
	
	@NotNull
	private Long idPessoa;

	public EnderecoDto() {
		
	}

	public EnderecoDto(
			@NotBlank(message = "Campo Obrigatório") @Size(min = 3, max = 255, message = "campo com no mínimo 3 e no máximo de 255 caracteres.") String logradouro,
			@NotBlank(message = "Campo Obrigatório") @Size(min = 8, max = 8, message = "campo com 8  caracteres.") String cep,
			Integer numero,
			@NotBlank(message = "Campo Obrigatório") @Size(min = 3, max = 255, message = "campo com no mínimo 3 e no máximo de 255 caracteres.") String cidade,
			@NotNull(message = "Campo Obrigatório") Boolean principal, @NotNull Long idPessoa) {
		
		this.logradouro = logradouro;
		this.cep = cep;
		this.numero = numero;
		this.cidade = cidade;
		this.principal = principal;
		this.idPessoa = idPessoa;
	}

	@Override
	public String toString() {
		return "EnderecoDto [logradouro=" + logradouro + ", cep=" + cep + ", numero=" + numero + ", cidade=" + cidade
				+ ", principal=" + principal + ", idPessoa=" + idPessoa + "]";
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public Boolean getPrincipal() {
		return principal;
	}

	public void setPrincipal(Boolean principal) {
		this.principal = principal;
	}

	public Long getIdPessoa() {
		return idPessoa;
	}

	public void setIdPessoa(Long idPessoa) {
		this.idPessoa = idPessoa;
	}
	
	
	
	

}
