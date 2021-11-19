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

import br.com.api.api_mercado.model.Venda;
import br.com.api.api_mercado.repository.VendasRepository;


@RestController
public class VendasController {
	
	@Autowired /*  CDI - INJEÇÃO DE DEPENDENCIA   */
	private VendasRepository vendasRepository;
	
	@PostMapping(value = "cadastrarVenda")
    @ResponseBody
    public ResponseEntity<?> cadastrarProduto(@RequestBody @Valid List<Venda> listaVenda){
	
		for (Venda vend : listaVenda) {
			if(vend.getQuantidade() <= 0) {
				return new ResponseEntity<String>(" COMPRE PELO MENOS 1 PRODUTO !!", HttpStatus.OK);
			}
			if(vend.getFun().getNome() != null  && !(vend.getFun().getNome().equals(""))) {
				vend.setFun(vendasRepository.buscaFuncionario(vend.getFun().getNome()));
				if(vend.getFun() == null) {
					return new ResponseEntity<String>(" ESSE FUNCIONARIO NÃO EXISTE !!", HttpStatus.OK);
				}else {
					vendasRepository.save(vend);
				}
			}else {
				return new ResponseEntity<String>(" PREENCHA O NOME DO FUNCIONARIO !!", HttpStatus.OK);
			}
		}
		
		return new ResponseEntity<List<Venda>>(listaVenda, HttpStatus.CREATED);
    }
	
	@GetMapping(value = "listarVendas")
    @ResponseBody /*  Retorna os dados paara o corpo da resposta   */
    public ResponseEntity<List<Venda>> listaVendas(){
    	
    	/*  Chama a interface que usa o metodo extendido da Interface JPArEPOSITORY  */
    	List<Venda> vendas = vendasRepository.findAll();
    	
    	return new ResponseEntity<List<Venda>>(vendas, HttpStatus.OK); /*  Retorna a lista em json  */
    }

}
