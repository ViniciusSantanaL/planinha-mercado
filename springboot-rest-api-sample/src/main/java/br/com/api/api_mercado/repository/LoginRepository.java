package br.com.api.api_mercado.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.api.api_mercado.model.Login;


@Repository
public interface LoginRepository extends JpaRepository<Login, Long>{
	
	@Query(value = "select lo from Login lo where lo.user = :name ")
	List<Login> buscaLogin(String name);

}
