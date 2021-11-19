package br.com.api.api_mercado.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.api.api_mercado.model.Funcionario;
import br.com.api.api_mercado.model.Venda;

@Repository
public interface VendasRepository extends JpaRepository<Venda, Long> {
		
	@Query(value = "select fun from Funcionario fu where fu like :name limit 1")
	Funcionario buscaFuncionario(String name);
}
