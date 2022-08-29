package com.gerenciador.backend.model;

import java.io.Serializable;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.gerenciador.backend.exception.MessageExceptionHandler;

@Entity
public class Endereco implements Serializable {

	
	private static final long serialVersionUID = -993561842368697421L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long idEndereco;
	
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
	
	
	
	@ManyToOne
	@JsonBackReference
	private Pessoa pessoa;


	public Endereco() {
		
		}


	public Endereco(Long idEndereco,
			@NotBlank(message = "Campo Obrigatório") @Size(min = 3, max = 255, message = "campo com no mínimo 3 e no máximo de 255 caracteres.") String logradouro,
			@NotBlank(message = "Campo Obrigatório") @Size(min = 8, max = 8, message = "campo com 8  caracteres.") String cep,
			Integer numero,
			@NotBlank(message = "Campo Obrigatório") @Size(min = 3, max = 255, message = "campo com no mínimo 3 e no máximo de 255 caracteres.") String cidade,
			@NotBlank(message = "Campo Obrigatório") Boolean principal, Pessoa pessoa) {
		
		this.idEndereco = idEndereco;
		this.logradouro = logradouro;
		boolean resposta = isValidaCep(cep);
		if(resposta) {
		this.cep = cep;
		}
		this.numero = numero;
		this.cidade = cidade;
		this.principal = principal;
		this.pessoa = pessoa;
	}
	
	
	
	
	public Endereco(Long  idEndereco,
			@NotBlank(message = "Campo Obrigatório") @Size(min = 3, max = 255, message = "campo com no mínimo 3 e no máximo de 255 caracteres.") String logradouro,
			@NotBlank(message = "Campo Obrigatório") @Size(min = 8, max = 8, message = "campo com 8  caracteres.") String cep,
			Integer numero,
			@NotBlank(message = "Campo Obrigatório") @Size(min = 3, max = 255, message = "campo com no mínimo 3 e no máximo de 255 caracteres.") String cidade,
			@NotBlank(message = "Campo Obrigatório") Boolean principal) {
		
				
		this.idEndereco =  idEndereco;
		this.logradouro = logradouro;
		
		boolean resposta = isValidaCep(cep);
		if(resposta) {
		this.cep = cep;
		}		
		this.numero = numero;
		this.cidade = cidade;
		this.principal = principal;
		
	}


	public Endereco(Long  idEndereco, Pessoa pessoa) {
		this.idEndereco =  idEndereco;
		this.pessoa = pessoa;
	}


	@Override
	public String toString() {
		return "Endereco [ idEndereco=" + idEndereco + ", logradouro=" + logradouro + ", cep=" + cep + ", numero=" + numero + ", cidade="
				+ cidade + ", principal=" + principal + ", pessoa=" + pessoa + "]";
	}


	public Long getIdEndereco() {
		return idEndereco;
	}


	public void setIdEndereco(Long  idEndereco) {
		this.idEndereco =  idEndereco;
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
		boolean resposta = isValidaCep(cep);
		if(resposta) {
		this.cep = cep;
		}
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


	public Pessoa getPessoa() {
		return pessoa;
	}


	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}


	@Override
	public int hashCode() {
		return Objects.hash(idEndereco);
	}
	
	
	
	public static boolean
    isValidaCep(String cep)
    {
 
        
 
       
        Pattern pattern = Pattern.compile("^\\d{8}$");
        Matcher matcher = pattern.matcher(cep);
 
               if (matcher.matches() == false) {
            	   throw	new MessageExceptionHandler("Cep inválido, informe apenas numeros, "
            	   		+ "sem espaços vazios e sem caracteres especiais ");
        }
               return true;
    }


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Endereco other = (Endereco) obj;
		return Objects.equals(idEndereco, other.idEndereco);
	}
	
	
	
	

		
	
}
