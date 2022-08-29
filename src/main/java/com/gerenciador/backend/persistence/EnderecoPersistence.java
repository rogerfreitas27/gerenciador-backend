package com.gerenciador.backend.persistence;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gerenciador.backend.exception.MessageExceptionHandler;
import com.gerenciador.backend.model.Endereco;
import com.gerenciador.backend.model.Pessoa;
import com.gerenciador.backend.repository.EnderecoRepository;
import com.gerenciador.backend.repository.PessoaRepository;

@Service
public class EnderecoPersistence {
	
	private final EnderecoRepository enderecoRepository;
	private final PessoaRepository pessoaRepository;
	
	public EnderecoPersistence(EnderecoRepository enderecoRepository,
			                   PessoaRepository pessoaRepository) {
		
	this.enderecoRepository=enderecoRepository;
	this.pessoaRepository = pessoaRepository;
	}
	
	
	
	public Endereco save(Endereco endereco) {
		//0 verificar se pessoa existe
		boolean resposta = pessoaRepository.existsById(endereco.getPessoa().getId());
		if(resposta == false) {
			throw	new MessageExceptionHandler("Não é possível cadastrar endereço com id de "
					+ "pessoa informado");
		}		
		
		//1 Buscar todos os endereços de uma pessoa		
		List<Endereco> enderecos = new ArrayList<>();
		enderecos = buscarEnderecosDePessoa(endereco.getPessoa().getId());		
		
		//2 Armazenar o endereço principal a parte
		Endereco enderecoPrincipal = new Endereco();
		enderecoPrincipal = buscaEnderecoPrincipal(enderecos);		
		return  gravaNoBancoDeDados(endereco,enderecoPrincipal);		
	}
	
	public Optional<Endereco> findById(Long id){
		return enderecoRepository.findById(id);
	}
	
	public List<Endereco> findAll(Long id){
		return buscarEnderecosDePessoa(id);
	}
	
     public Endereco updateEnderecoPrincipal(Long id) {
    	 Endereco endereco = new Endereco();
	     // 1 verifico se o id existe    	 
    	 boolean  resposta;
    	 resposta = enderecoRepository.existsById(id);
    	 
    	 if(resposta == false) {
    		 throw	new MessageExceptionHandler("Não existe endereço com este id");
    	 }
    	 
    	
    	 // 2 busco os dados do id
    	 Optional<Endereco> end =  enderecoRepository.findById(id);
    	 
    	 if(end.isPresent()) {
    		endereco = end.get(); 
    	 }
    	 
    	 
    	 // 3 listo todos os endereços da pessoa
    	 List<Endereco> enderecos = new ArrayList<>();
    	 enderecos = buscarEnderecosDePessoa(endereco.getPessoa().getId());
    	 
    	 
    	 // 4 Onde o endereço for true eu seto false
    	// 5 Onde o id for igual ao vindo da api eu seto true
    	 for(Endereco itemEndereco: enderecos) {
    		if(itemEndereco.getPrincipal()==true) {
    			itemEndereco.setPrincipal(false);
    		}
    		
    		if(itemEndereco.getIdEndereco()==id) {
    			itemEndereco.setPrincipal(true);
    		}
    	 }
    	 
    	 enderecoRepository.saveAll(enderecos);
    	 
    	 // 6 retorno o endereco alterado
    	 
    	 return endereco;
     }
	
	
	public void saveAll(List<Endereco> enderecos) {
		enderecoRepository.saveAll(enderecos);
		}
   
	
	
	
	
	
	
	public List<Endereco> buscarEnderecosDePessoa(Long id){
		List<Endereco> enderecos = new ArrayList<>();
		Optional<Pessoa> pessoa;
		pessoa = pessoaRepository.findById(id);
		Pessoa p = new Pessoa();
		if(pessoa.isPresent()) {
			p = pessoa.get();
			enderecos = p.getEnderecos();
		}
		
		return enderecos;
	}
	
	
	
	
	
	
	private Endereco buscaEnderecoPrincipal(List<Endereco> enderecos) {
		Endereco enderecoPrincipal  = new Endereco();
		for(Endereco end : enderecos) {
			if(end.getPrincipal()==true) {
				enderecoPrincipal = end;
				break;
			}
		}
		return enderecoPrincipal;
	}
	
	
	@Transactional
	private  Endereco gravaNoBancoDeDados(Endereco enderecoApi,Endereco enderecoPrincipal) {
		//3 Verificar se o novo endereco é principal
				if(enderecoApi.getPrincipal()==true) {
					// 3 A) caso seja, seto o valor de false no antigo principal  e salvo
					enderecoPrincipal.setPrincipal(false);
					
					enderecoRepository.save(enderecoPrincipal);
					return enderecoRepository.save(enderecoApi);
				}
						
				// 3 B) caso nao seja eu salvo direto		
				return enderecoRepository.save(enderecoApi);
	}
	
	public boolean verificaSeEnderecosExistem(List<Endereco> enderecos) {
		boolean resposta = true;
		
		for(Endereco end : enderecos) {
			if(end.getIdEndereco()==null) {
				 throw	new MessageExceptionHandler("Id de endrereço vazio ou nulo");
			}
			resposta = enderecoRepository.existsById(end.getIdEndereco());
			if(resposta == false) {
				break;
			}
		}
		return resposta;
	}
}
