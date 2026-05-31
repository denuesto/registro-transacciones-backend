package com.demo.transacciones.service;

import com.demo.transacciones.dto.request.UsuarioRequest;
import com.demo.transacciones.dto.response.UsuarioResponse;

public interface LoginService {
	
	UsuarioResponse findByUsernameAndPass(UsuarioRequest usuarioRequest);

}
