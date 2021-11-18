package br.com.api.api_mercado.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.api.api_mercado.model.Funcionario;

@Repository
public interface FuncionarioRepository extends JpaRepository<Funcionario, Long> {

}
