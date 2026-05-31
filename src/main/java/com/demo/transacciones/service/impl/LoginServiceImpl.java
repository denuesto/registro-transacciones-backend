package com.demo.transacciones.service.impl;

import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.demo.transacciones.dto.request.UsuarioRequest;
import com.demo.transacciones.dto.response.UsuarioResponse;
import com.demo.transacciones.entity.Usuario;
import com.demo.transacciones.mapper.UsuarioMapper;
import com.demo.transacciones.repository.LoginRepository;
import com.demo.transacciones.service.LoginService;

@Service
public class LoginServiceImpl implements LoginService {
	
	private final LoginRepository loginRepository;
	private final UsuarioMapper usuarioMapper;

	public LoginServiceImpl(LoginRepository loginRepository, UsuarioMapper usuarioMapper) {
		this.loginRepository = loginRepository;
		this.usuarioMapper = usuarioMapper;
	}
	
	@Override
	public UsuarioResponse findByUsernameAndPass(UsuarioRequest usuarioRequest) {
		Usuario usuario = loginRepository.findByUsernameAndPass(usuarioRequest.getUsername(), usuarioRequest.getPass());
		UsuarioResponse usuarioResponse = null;
		if(usuario == null ) {
			throw new ResponseStatusException(HttpStatus.UNAUTHORIZED,"Usuario y/o contraseña incorrectos");
		}
		usuarioResponse = usuarioMapper.toDTO(usuario);
		usuarioResponse.setStatus("OK");
		usuarioResponse.setTransactionId(UUID.randomUUID().toString());
		
		
		return usuarioResponse;
	}

}
