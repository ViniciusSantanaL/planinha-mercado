package br.com.api.api_mercado.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.api.api_mercado.model.Funcionario;
import br.com.api.api_mercado.model.Login;

@Repository
public interface FuncionarioRepository extends JpaRepository<Funcionario, Long> {
		
	@Query(value = "select fun from Funcionario fu where fu like :name")
	List<Login> buscaFuncionario(String name);
}
