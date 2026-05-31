package com.denuesto.registrotransaccionesbackend.dto;

import com.denuesto.registrotransaccionesbackend.domain.TipoTransaccion;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record TransaccionRequest(
        @NotBlank String descripcion,
        @NotNull @DecimalMin("0.01") BigDecimal monto,
        @NotNull TipoTransaccion tipo,
        @NotNull LocalDateTime fecha
) {
}
