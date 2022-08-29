package com.gerenciador.backend.rest;



import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gerenciador.backend.exception.MessageExceptionHandler;

import com.gerenciador.backend.rel.Relatorio;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/api/pessoa/relatorio")
public class RelatorioPessoaRest {

	
	@Autowired
	private Relatorio relatorio;
	
	 @GetMapping(value="relatorioPessoa/", produces="application/text")
	  @Operation(summary = "Endpoint para relatório em PDF de todas as pessoas cadastradas no sistema")	 
	 @ApiResponses(value = { 		  
			  @ApiResponse(responseCode = "200", description = "Relatório gerado"),
			  @ApiResponse(responseCode = "400", description = "Falha ao gerar relatório") })
	  public ResponseEntity<?> relatorioDePessoas(HttpServletRequest request)throws Exception {	
		
		
		 byte[] pdf = relatorio.gerarRelatorio("reports_pessoas", request.getServletContext());
		 String base64PDF="data:application/pdf;base64," + Base64.encodeBase64String(pdf);
		 		
		  return ResponseEntity.status(HttpStatus.OK).body(base64PDF);
		 
	  }
	 
	 @GetMapping(value="relatorioEnderecoPessoa/{id}", produces="application/text")
	  @Operation(summary = "Endpoint para relatório em PDF de todos os endereços de uma pessoa")	 
	 @ApiResponses(value = { 		  
			  @ApiResponse(responseCode = "200", description = "Relatório gerado"),
			  @ApiResponse(responseCode = "400", description = "Falha ao gerar relatório") })
	  public ResponseEntity<?> relatorioDeEnderecosPorPessoa(@PathVariable("id") Long id)throws Exception {	
		
		 
		 HashMap<String,Long> parametroRelatorio = new HashMap<>();
		 parametroRelatorio.put("id_pessoa", id);
		 byte[] pdf = relatorio.relatorioEnderecoPessoa("reports_enderecos_pessoa", parametroRelatorio);
		 String base64PDF="data:application/pdf;base64," + Base64.encodeBase64String(pdf);
		 		
		  return ResponseEntity.status(HttpStatus.OK).body(base64PDF);
		 
	  }
}
