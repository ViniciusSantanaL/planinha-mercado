package br.com.api.api_mercado.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.api.api_mercado.model.Login;
import br.com.api.api_mercado.repository.LoginRepository;


@RestController
public class LoginController {
	
	@Autowired /*  CDI - INJEÇÃO DE DEPENDENCIA   */
	private LoginRepository loginRepository;
	
	@PostMapping(value = "cadastrarLogin")
    @ResponseBody
    public ResponseEntity<?> cadastrarLogin(@RequestBody @Valid Login usr){
		
		usr.setUserNome(usr.getUserNome().trim());
	
		List<Login> listaLogin = loginRepository.findAll();
		
		for (Login login : listaLogin) {
			if(login.getUserNome().contains(usr.getUserNome())) {
				return new ResponseEntity<String>("Este Usuario ja existe !!", HttpStatus.OK);
			}
		}
		Login user = loginRepository.save(usr);
			
		return new ResponseEntity<Login>(user, HttpStatus.CREATED);
    }
	
	@PostMapping(value = "login")
    @ResponseBody
    public ResponseEntity<?> efetuarLogin(@RequestBody @Valid Login usr){
		
		usr.setUserNome(usr.getUserNome().trim());
		
		List<Login> listaLogin = loginRepository.findAll();
		
		for (Login login : listaLogin) {
			if(login.getUserNome().contains(usr.getUserNome())) {
				return new ResponseEntity<Login>(usr, HttpStatus.OK);
			}
		}	
		
		return new ResponseEntity<String>("Este Login de User NAO EXISTE !!", HttpStatus.OK);
		
    }

}
