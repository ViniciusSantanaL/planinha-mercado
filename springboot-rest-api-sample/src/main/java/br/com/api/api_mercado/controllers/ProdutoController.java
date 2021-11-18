package br.com.api.api_mercado.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.api.api_mercado.model.Funcionario;
import br.com.api.api_mercado.model.Login;
import br.com.api.api_mercado.model.Produto;
import br.com.api.api_mercado.repository.LoginRepository;
import br.com.api.api_mercado.repository.ProdutoRepository;


@RestController
public class ProdutoController {
	
	@Autowired /*  CDI - INJEÇÃO DE DEPENDENCIA   */
	private ProdutoRepository produtoRepository;
	
	@PostMapping(value = "cadastrarProduto")
    @ResponseBody
    public ResponseEntity<?> cadastrarLogin(@RequestBody @Valid Produto prod){
		
		prod.setNome(prod.getNome().trim());
	
		List<Produto> listaPro = produtoRepository.findAll();
		
		for (Produto pro : listaPro) {
			if(pro.getNome().contains(prod.getNome())) {
				return new ResponseEntity<String>("Este Produto ja existe !!", HttpStatus.OK);
			}
		}
		Produto pro = produtoRepository.save(prod);
			
		return new ResponseEntity<Produto>(pro, HttpStatus.CREATED);
    }
	
	@GetMapping(value = "listarProduto")
    @ResponseBody /*  Retorna os dados paara o corpo da resposta   */
    public ResponseEntity<List<Produto>> listaProduto(){
    	
    	/*  Chama a interface que usa o metodo extendido da Interface JPArEPOSITORY  */
    	List<Produto> produtos = produtoRepository.findAll();
    	
    	return new ResponseEntity<List<Produto>>(produtos, HttpStatus.OK); /*  Retorna a lista em json  */
    }

}
