package br.com.api.api_mercado.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.api.api_mercado.model.Produto;


@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long>{
	
	//@Query(value = "select lo from Login lo where lo.user = :name ")
	//List<Login> buscaLogin(String name);

}
