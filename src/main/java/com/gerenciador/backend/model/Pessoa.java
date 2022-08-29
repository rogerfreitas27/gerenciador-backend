package com.gerenciador.backend.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;



import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class Pessoa implements Serializable {

	private static final long serialVersionUID = -4656873450317964235L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank(message="Campo Obrigatório")
	@Size(min = 3, max=255,message="campo com no mínimo 3 e no máximo de 255 caracteres.")
	private String nome;
	
	@NotNull(message="Campo Obrigatório")
	private LocalDate dataNascimento;	
	
	@OneToMany(mappedBy = "pessoa", cascade=CascadeType.ALL)
	@JsonManagedReference
	private List<Endereco> enderecos;

	public Pessoa() {
		
	}

	public Pessoa(Long id,
			@NotBlank(message = "Campo Obrigatório") @Size(min = 3, max = 255, message = "campo com no mínimo 3 e no máximo de 255 caracteres.") String nome,
			@NotBlank(message = "Campo Obrigatório") LocalDate dataNascimento, List<Endereco> enderecos) {
		
		this.id = id;
		this.nome = nome;
		this.dataNascimento = dataNascimento;
		this.enderecos = enderecos;
	}

	public Pessoa(Long id,
			@NotBlank(message = "Campo Obrigatório") @Size(min = 3, max = 255, message = "campo com no mínimo 3 e no máximo de 255 caracteres.") String nome,
			@NotBlank(message = "Campo Obrigatório") LocalDate dataNascimento) {
		
		this.id = id;
		this.nome = nome;
		this.dataNascimento = dataNascimento;
	}

	@Override
	public String toString() {
		return "Pessoa [id=" + id + ", nome=" + nome + ", dataNascimento=" + dataNascimento + ", enderecos=" + enderecos
				+ "]";
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public LocalDate getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public List<Endereco> getEnderecos() {
		return enderecos;
	}

	public void setEnderecos(List<Endereco> enderecos) {
		this.enderecos = enderecos;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pessoa other = (Pessoa) obj;
		return Objects.equals(id, other.id);
	}
	
	
	
	
	
	
	
	
	
	

}
