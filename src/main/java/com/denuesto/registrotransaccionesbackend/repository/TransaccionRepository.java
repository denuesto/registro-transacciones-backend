package com.denuesto.registrotransaccionesbackend.repository;

import com.denuesto.registrotransaccionesbackend.domain.Transaccion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransaccionRepository extends JpaRepository<Transaccion, Long> {
}
