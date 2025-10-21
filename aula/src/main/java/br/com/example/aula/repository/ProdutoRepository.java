package br.com.example.aula.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.example.aula.model.Produto;

@Repository
public interface ProdutoRepository extends CrudRepository<Produto, Long>{

}
