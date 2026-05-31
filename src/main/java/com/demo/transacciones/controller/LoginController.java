package com.demo.transacciones.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.transacciones.dto.request.UsuarioRequest;
import com.demo.transacciones.dto.response.UsuarioResponse;
import com.demo.transacciones.service.LoginService;

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/api/v1/auth")
@CrossOrigin(origins = "http://localhost:4200")
@Slf4j
public class LoginController {
	
	private final LoginService loginService;
	
	public LoginController(LoginService loginService) {
		this.loginService = loginService;
	}

	@PostMapping("/login")
	public ResponseEntity<UsuarioResponse> login(@Valid @RequestBody UsuarioRequest usuarioRequest){
		log.info("Ingreso login request {},",usuarioRequest);
		UsuarioResponse usuarioResponse = loginService.findByUsernameAndPass(usuarioRequest);
		
		log.info("fin login response {},",usuarioResponse);
		return ResponseEntity.status(HttpStatus.OK).body(usuarioResponse);
	}
	
}
