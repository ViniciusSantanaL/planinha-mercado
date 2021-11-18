package br.com.api.api_mercado.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.api.api_mercado.model.Funcionario;
import br.com.api.api_mercado.repository.FuncionarioRepository;

/**
 *
 * A sample greetings controller to return greeting text
 */
@RestController
public class FuncionarioController {
	
	@Autowired /*  CDI - INJEÇÃO DE DEPENDENCIA   */
	private FuncionarioRepository funcRepository;
	
    /**
     *
     * @param name the name to greet
     * @return greeting text
     */
    @RequestMapping(value = "/{name}", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public String greetingText(@PathVariable String name) {
        return "Requisao GET Padrao, Olá: " + name + "!";
    }
    
    @GetMapping(value = "listaTodosFuncio")
    @ResponseBody /*  Retorna os dados paara o corpo da resposta   */
    public ResponseEntity<List<Funcionario>> listafunc(){
    	
    	/*  Chama a interface que usa o metodo extendido da Interface JPArEPOSITORY  */
    	List<Funcionario> funcs = funcRepository.findAll();
    	
    	return new ResponseEntity<List<Funcionario>>(funcs, HttpStatus.OK); /*  Retorna a lista em json  */
    }
    
    @PostMapping(value = "cadastrarFuncionario")
    @ResponseBody
    public ResponseEntity<Funcionario> salvar(@RequestBody @Valid Funcionario func){
    	Funcionario user = funcRepository.save(func);
    	
    	return new ResponseEntity<Funcionario>(user, HttpStatus.CREATED);
    }
    
    @DeleteMapping(value = "deletarFuncio")
    @ResponseBody /*  Retorna os dados paara o corpo da resposta   */
    public ResponseEntity<String> delete(@RequestParam Long idUser){
    	
    	funcRepository.deleteById(idUser);
    	
    	return new ResponseEntity<String>("User Deletado com sucesso", HttpStatus.OK);
    }
    
    @PutMapping(value = "atualizarFuncionario")
    @ResponseBody /*  Retorna os dados paara o corpo da resposta   */
    public ResponseEntity<Funcionario> atualizar(@RequestBody @Valid  Funcionario func){
    	
  	
    	Funcionario user = funcRepository.saveAndFlush(func);
    	
    	return new ResponseEntity<Funcionario>(user, HttpStatus.OK);
    }
    
}
