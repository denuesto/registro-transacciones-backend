package com.demo.transacciones.dto.response;

import lombok.Data;

@Data
public class UsuarioResponse {
	private String username;
	private String status;
	private String transactionId;
}
