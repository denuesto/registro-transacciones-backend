package com.demo.transacciones.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class UsuarioRequest {
	@NotBlank(message = "El campo usuario es obligatorio")
	@Size(min = 2, max = 50, message ="El mínimo es {min} y máximo permitido es {max} caracteres")
	private String username;
	
	@NotBlank(message = "El campo contraseña es obligatorio")
	@Size(min = 3, max = 50, message ="El mínimo es {min} y máximo permitido es {max} caracteres")
	private String pass;

}
