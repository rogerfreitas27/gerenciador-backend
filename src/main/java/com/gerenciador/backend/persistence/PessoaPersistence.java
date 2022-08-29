package com.gerenciador.backend.persistence;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.data.domain.Pageable;

import com.gerenciador.backend.exception.MessageExceptionHandler;
import com.gerenciador.backend.model.Endereco;
import com.gerenciador.backend.model.Pessoa;
import com.gerenciador.backend.repository.PessoaRepository;
import com.gerenciador.backend.validation.ValidationEndereco;

@Service
public class PessoaPersistence {
	
	private final PessoaRepository pessoaRepository;
	private final ValidationEndereco validationEndereco;
	private final EnderecoPersistence enderecoPersistence;

	public PessoaPersistence(PessoaRepository pessoaRepository,
			ValidationEndereco validationEndereco,
			EnderecoPersistence enderecoPersistence) {
	this.pessoaRepository=pessoaRepository;	
	this.validationEndereco = validationEndereco;
	this.enderecoPersistence = enderecoPersistence;
	}
	
	@Transactional
	public Pessoa save(Pessoa pessoa) {
				
		List<Endereco> enderecos = new ArrayList<>();
		enderecos = pessoa.getEnderecos();
		pessoa = validationEndereco.verificaIdCadastro(pessoa);
		Pessoa p = new Pessoa();
		p = pessoaRepository.save(pessoa);
		for(Endereco end: enderecos) {
			end.setPessoa(p);			
		}
		enderecoPersistence.saveAll(enderecos);
		
		 p.setEnderecos(enderecos);
		 return p;
	
		
	}
	
	
	
	 //3 verificar se existe um endereço principal
	 //3 A) se a lista vinda da api tiver endereço principal(1 apenas), eu seto  false 
	 //		 no principal da lista do banco , junto as listas num lista que nao pode ser igual
	  //     atualizo a lista no banco
	 
	 @Transactional
   public Pessoa update(Pessoa pessoa) {
	   
	 //1 verificar se id da pessoa e os ids de endereço existem
	   verificaIds (pessoa);
	  
	   //2 carregar lista de endereços
	   List<Endereco> enderecosBancoDeDados = new ArrayList<>();
	   enderecosBancoDeDados =  enderecoPersistence.buscarEnderecosDePessoa(pessoa.getId());
	   
	   int contadorEnderecoPrincipalApi = validationEndereco.verificaQuantidadeDeEnderecoPrincipalTrue(pessoa.getEnderecos());
	  	   
	  // Caso a lista da api nao tenha endereco principal eu salvo direto
	   if(contadorEnderecoPrincipalApi ==0) {
		   //Aqui eu verifico se as listas ficarão vazias 
		   pessoa.setEnderecos(validationEndereco.verificaPrincipalEmDuasListas(pessoa.getEnderecos(),  enderecosBancoDeDados));
		  
		   pessoa = pessoaRepository.save(pessoa);
			enderecoPersistence.saveAll(pessoa.getEnderecos());
			
			return pessoa;

			}  
	   
	   	   
	 //caso tenha eu seto false em todos os principais vindo do banco
	   for(Endereco end: enderecosBancoDeDados) {
		   end.setPrincipal(false);  
	   }
	   
	   enderecoPersistence.saveAll(enderecosBancoDeDados);
	  
	   
	     
	   
	   	   
	   // E salvo a lista de endereços vinda da api normalmente
	   List<Endereco> novaListaEnderecos = new ArrayList<>();
	   
	   for(Endereco enderecoApi : pessoa.getEnderecos() ) {		   
		   for(Endereco enderecoBanco :enderecosBancoDeDados) {
			   
			   if(enderecoApi.getIdEndereco()== enderecoBanco.getIdEndereco()) {
				   novaListaEnderecos.add(enderecoApi);
			   }
		   }
	   	   
	   }
	   pessoa = pessoaRepository.save(pessoa);
	   enderecoPersistence.saveAll(novaListaEnderecos);
	   	   
	   					return pessoa;
   }
	
   
	public Optional<Pessoa> findById(Long id){
		return pessoaRepository.findById(id);
	}
	
	public Page<Pessoa> findAll(Pageable peageble){
		return pessoaRepository.findAll(peageble);
	}
	
	public boolean pessoaExist(Long id) {
		return pessoaRepository.existsById(id);
	}
	
	
	private void verificaIds(Pessoa pessoa) {
		if(pessoa.getId()==null) {
			System.out.println("Entrei aqui no erro");
			 throw	new MessageExceptionHandler("Id de pessoa vazio ou nulo");
		}
		 boolean resposta = pessoaRepository.existsById(pessoa.getId()) ;
		  		 
		if(resposta==false) {
			   throw	new MessageExceptionHandler("Id de pessoa invalido");
		   }
		   
		   resposta = enderecoPersistence.verificaSeEnderecosExistem(pessoa.getEnderecos());
		   if(resposta==false) {
			   throw	new MessageExceptionHandler("Id do endereco invalido");
		   }
		   
	}
	
	
}
