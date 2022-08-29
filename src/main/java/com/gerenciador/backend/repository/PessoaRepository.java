package com.gerenciador.backend.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gerenciador.backend.model.Pessoa;

@Repository
public interface PessoaRepository  extends JpaRepository<Pessoa,Long>{

	

}
