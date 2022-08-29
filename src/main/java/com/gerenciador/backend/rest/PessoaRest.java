package com.gerenciador.backend.rest;



import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;



import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;

import com.gerenciador.backend.model.Pessoa;
import com.gerenciador.backend.persistence.PessoaPersistence;


@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/api/pessoa")
public class PessoaRest {
	
	
	private final PessoaPersistence pessoaPersistence;
	
	
	
	
	public PessoaRest(PessoaPersistence pessoaPersistence) {
	this.pessoaPersistence=pessoaPersistence;	
	}
	
	@PostMapping
	  @Operation(summary = "Endpoint para cadastro de pessoa com endereço")	 
	 @ApiResponses(value = { 		  
			  @ApiResponse(responseCode = "201", description = "Pessoa cadastrada com sucesso "),
			  @ApiResponse(responseCode = "400", description = "Falha ao cadastrar"),
			  @ApiResponse(responseCode = "405", description = "Quando uma pessoa já existe, a api "
			  		+ "responde 405, pois este metodo é para cadastro não alteração")			
			  })
	  public ResponseEntity<?> save(@Valid @RequestBody Pessoa pessoa) {	
		
		
		
		pessoa = pessoaPersistence.save(pessoa);
		  return ResponseEntity.status(HttpStatus.CREATED).body(pessoa);
		  
	  }
	
	
	@GetMapping
	  @Operation(summary = "Endpoint para buscar todas as pessoas, a api devolve a lista de pessoas"
	  		+ "paginada")
	 @ApiResponses(value = { 		  
			  @ApiResponse(responseCode = "200", description = "Buscar todas as pessoas "), 
			  @ApiResponse(responseCode = "404", description = "Não há registro de pessoas")			  
			  })
	 
	 public ResponseEntity<?> findAll(@PageableDefault(size=10) Pageable peageable){
		  PageRequest pageRequest = null;
		  pageRequest=PageRequest.of(peageable.getPageNumber(),peageable.getPageSize(), peageable.getSort());
		
		  Page<Pessoa> pessoas = pessoaPersistence.findAll(pageRequest);
		 
		  if( pessoas.getTotalPages() < 1) {
			  return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Ainda não há registros de pessoas");
		  }
		  return  ResponseEntity.ok(pessoaPersistence.findAll(pageRequest));
	  }  
	
	
	
	 @GetMapping("/{id}")
	  @Operation(summary = "Endpoint para buscar pessoa por id")
	  @ApiResponses(value = { 		  
			  @ApiResponse(responseCode = "200", description = "Pessoa encontrada"), 
			  @ApiResponse(responseCode = "404", description = "Pessoa não encontrado") })
	  public ResponseEntity<?>findById(@PathVariable("id") Long id){
		  return pessoaPersistence.findById(id).map(record -> ResponseEntity.ok().body(record))
					.orElse(ResponseEntity.notFound().build());
	 }	  
	 
	 
	 
	 @PutMapping
	  @Operation(summary = "Endpoint para atualizar cadastro")	 
	 @ApiResponses(value = { 		  
			  @ApiResponse(responseCode = "200", description = "Cadastrado atualizado com sucesso "), 
			  @ApiResponse(responseCode = "400", description = "Falha ao atualizar  cadastro")			
			  })
	  public ResponseEntity<?> update(@Valid @RequestBody Pessoa pessoa) {	
		 
		
		
		  return ResponseEntity.status(HttpStatus.OK).body(pessoaPersistence.update(pessoa));
		  
	  }
	  

	 
	 
	 
	
}
