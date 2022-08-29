package com.gerenciador.backend.rest;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gerenciador.backend.dto.EnderecoDto;
import com.gerenciador.backend.model.Endereco;
import com.gerenciador.backend.model.Pessoa;
import com.gerenciador.backend.persistence.EnderecoPersistence;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/api/endereco")
public class EnderecoRest {

	
	private final EnderecoPersistence enderecoPersistence;
	
	public EnderecoRest(EnderecoPersistence enderecoPersistence) {
		this.enderecoPersistence = enderecoPersistence;
	}
	
	@PostMapping
	  @Operation(summary = "Endpoint para cadastro de  endereço")	 
	 @ApiResponses(value = { 		  
			  @ApiResponse(responseCode = "201", description = "Endereco cadastrado com sucesso "), 
			  @ApiResponse(responseCode = "400", description = "Falha ao cadastrar")			
			  })
	  public ResponseEntity<?> save(@Valid @RequestBody EnderecoDto enderecoDto) {
		Pessoa pessoa = new Pessoa();
		pessoa.setId(enderecoDto.getIdPessoa());
		Endereco endereco = new Endereco(null,enderecoDto.getLogradouro(),enderecoDto.getCep(),enderecoDto.getNumero(), enderecoDto.getCidade(), enderecoDto.getPrincipal() , pessoa);
				  return ResponseEntity.status(HttpStatus.CREATED).body(enderecoPersistence.save(endereco));
		  
	  }
	
	
	@GetMapping("/{id}")
	  @Operation(summary = "Endpoint para buscar todos os endereços de uma pessoa")
	 @ApiResponses(value = { 		  
			  @ApiResponse(responseCode = "200", description = "Pelo menos um endereço encontrado"), 
			  @ApiResponse(responseCode = "404", description = "Não há registro de endereços")			  
			  })
	 public ResponseEntity<?>findAll(@PathVariable("id") Long id){
		List<Endereco> enderecos = new ArrayList<>();
		enderecos = enderecoPersistence.findAll(id);
		
		if(enderecos.size()==0) {
			 return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Não há registros");
		}
		 return ResponseEntity.status(HttpStatus.OK).body(enderecos);
	}
	
	
	@GetMapping("/update/{id}")
	  @Operation(summary = "Endpoint para atualizar endereço principal")
	 @ApiResponses(value = { 		  
			  @ApiResponse(responseCode = "200", description = "Atualização realizada com sucesso"), 
			  @ApiResponse(responseCode = "400", description = "Falha ao atualizar")			  
			  })
	 public ResponseEntity<?>update(@PathVariable("id") Long id){
	return ResponseEntity.status(HttpStatus.OK).body(enderecoPersistence.updateEnderecoPrincipal(id)); 
			
		
		
	}
	
	
}
