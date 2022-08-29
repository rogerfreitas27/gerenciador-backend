package com.gerenciador.backend.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gerenciador.backend.model.Endereco;

@Repository
public interface EnderecoRepository extends JpaRepository<Endereco,Long> {

	
	
	
	
}
