package com.denuesto.registrotransaccionesbackend.exception;

public class TransaccionNotFoundException extends RuntimeException {

    public TransaccionNotFoundException(Long id) {
        super("Transacción no encontrada con id " + id);
    }
}
