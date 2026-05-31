package com.demo.transacciones.mapper;

import org.mapstruct.Mapper;

import com.demo.transacciones.dto.request.UsuarioRequest;
import com.demo.transacciones.dto.response.UsuarioResponse;
import com.demo.transacciones.entity.Usuario;

@Mapper(componentModel = "spring")
public interface UsuarioMapper {
	
	public UsuarioResponse toDTO(Usuario usuario);
	public Usuario toEntity(UsuarioRequest usuarioRequest);

}
