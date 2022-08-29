package com.gerenciador.backend.validation;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.gerenciador.backend.exception.MessageExceptionHandler;
import com.gerenciador.backend.model.Endereco;
import com.gerenciador.backend.model.Pessoa;

@Service
public class ValidationEndereco {

	public Pessoa verificaIdCadastro(Pessoa pessoa) {
	boolean resposta =	verificarSeIDTemValor(pessoa);
	Pessoa p =  new Pessoa();
	if(resposta) {
		p = validaEnderecoParaCadastro(pessoa);
	  }
	
	return p;
	}
	
	
	
	public Pessoa validaEnderecoParaCadastro(Pessoa pessoa) {
		List<Endereco> enderecos = new ArrayList<>();
		enderecos = pessoa.getEnderecos();
		int quantidadeEnderecoPrincipalTrue = 0;
		int quantidadeEnderecoPrincipalFalse = 0;
		int quantidadeRegistro =   contaRegistrosEndereco(enderecos);
		
		if(quantidadeRegistro==0) {
			throw	new MessageExceptionHandler("Para salvar este registro  é necessario ter pelo menos 1 endereco");
		}
		
				
		if(quantidadeRegistro >= 1) {
			
			quantidadeEnderecoPrincipalTrue = verificaQuantidadeDeEnderecoPrincipalTrue(enderecos);
			quantidadeEnderecoPrincipalFalse = verificaQuantidadeDeEnderecoPrincipalFalse(enderecos);
			
			//Neste caso todos os endereços principais são false
			if(quantidadeEnderecoPrincipalFalse == quantidadeRegistro ) {
				throw	new MessageExceptionHandler("Pelo menos um endereço tem quer ser endereço principal");
			}
		}
		
		if(quantidadeEnderecoPrincipalTrue < 1) {
			enderecos = setaEnderecoPrincipalUmRegistro(enderecos);
		}
		
		pessoa.setEnderecos(enderecos);
		return pessoa;
	}
	
	
	
	
	/**Método conta a quantidade de registros em uma lista de endereço
	 * 
	 * @param Recebe uma lista de enderecos  
	 * @return Um inteiro com a quantidade de registros 
	 */
	public int  contaRegistrosEndereco(List<Endereco> enderecos) {
		int quantidadeDeEnderecos= enderecos.size();
		return quantidadeDeEnderecos;
	}
	
	
	/**Método verifica se na lista tem mais de um endereco principal
	 * 
	 * @param Recebe uma lista de enderecos  
	 * @return A quantidade de endereço principal ou uma exceção se tiver mais de
	 *  um endereço principal
	 */
	public int verificaQuantidadeDeEnderecoPrincipalTrue(List<Endereco> enderecos) {
		int contador =0;
		for(Endereco end: enderecos) {
						
			if(end.getPrincipal()==true) {
				contador ++;				
				if(contador >1 ) {
				throw	new MessageExceptionHandler("Não é possível ter mais que um endereço principal");
				}
			}
			
		}
		
		return contador;
	}
	
	
	
	
	
	/**Método verifica se na lista todos os enderecos principais são false
	 * 
	 * @param Recebe uma lista de enderecos  
	 * @return A quantidade de endereço false ou uma exceção se tiver mais de
	 *  um endereço principal
	 */
	public int verificaQuantidadeDeEnderecoPrincipalFalse(List<Endereco> enderecos) {
		int contador =0;
		for(Endereco end: enderecos) {
						
			if(end.getPrincipal()==false) {
				contador ++;				
				
			}
			
		}
		
		return contador;
	}
	
	
	
	/**Método para setar endereco principal
	 * 
	 * @param Recebe uma lista de enderecos  
	 * @return  endereço principal setado
	 */
	public List<Endereco> setaEnderecoPrincipalUmRegistro(List<Endereco> enderecos){
		
		for(Endereco end: enderecos) {			
			end.setPrincipal(true);			
		}
		
		return enderecos;
		
	}
	public List<Endereco> verificaPrincipalEmDuasListas(List<Endereco> enderecosApi,List<Endereco> enderecosBanco){
		
		for(Endereco endApi:enderecosApi) {
			for(Endereco endBanco :enderecosBanco ) {
				
				// Os mesmos registros
				if(endApi.getIdEndereco() == endBanco.getIdEndereco()) {
					if(endApi.getPrincipal()==false && endBanco.getPrincipal()==true ) {
						throw	new MessageExceptionHandler("Pelo menos um endereço precisa ser principal");
					}
					 
				}
			}
		}
		
		return  enderecosApi;
	}
	
	
	private boolean verificarSeIDTemValor(Pessoa pessoa) {
		
		if(pessoa.getId() != null) {
			throw	new MessageExceptionHandler("Para cadastro, id de pessoa  precisa ser vazio");
		}
		
		for(Endereco endereco:pessoa.getEnderecos()) {
			
			if(endereco.getIdEndereco() !=null) {
				throw	new MessageExceptionHandler("Para cadastro, id de endereco precisa ser vazio");
			}
		}
		
		return true;
		
	}
	
}
