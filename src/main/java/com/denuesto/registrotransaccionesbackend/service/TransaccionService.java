package com.denuesto.registrotransaccionesbackend.service;

import com.denuesto.registrotransaccionesbackend.domain.Transaccion;
import com.denuesto.registrotransaccionesbackend.dto.TransaccionRequest;
import com.denuesto.registrotransaccionesbackend.exception.TransaccionNotFoundException;
import com.denuesto.registrotransaccionesbackend.repository.TransaccionRepository;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransaccionService {

    private final TransaccionRepository repository;

    public TransaccionService(TransaccionRepository repository) {
        this.repository = repository;
    }

    public List<Transaccion> listar() {
        return repository.findAll(Sort.by(Sort.Direction.DESC, "fecha", "id"));
    }

    public Transaccion obtener(Long id) {
        return repository.findById(id).orElseThrow(() -> new TransaccionNotFoundException(id));
    }

    public Transaccion crear(TransaccionRequest request) {
        Transaccion transaccion = new Transaccion();
        map(request, transaccion);
        return repository.save(transaccion);
    }

    public Transaccion actualizar(Long id, TransaccionRequest request) {
        Transaccion actual = obtener(id);
        map(request, actual);
        return repository.save(actual);
    }

    public void eliminar(Long id) {
        Transaccion actual = obtener(id);
        repository.delete(actual);
    }

    private void map(TransaccionRequest request, Transaccion target) {
        target.setDescripcion(request.descripcion().trim());
        target.setMonto(request.monto());
        target.setTipo(request.tipo());
        target.setFecha(request.fecha());
    }
}
