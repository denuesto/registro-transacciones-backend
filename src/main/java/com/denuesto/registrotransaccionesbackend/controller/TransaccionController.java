package com.denuesto.registrotransaccionesbackend.controller;

import com.denuesto.registrotransaccionesbackend.domain.Transaccion;
import com.denuesto.registrotransaccionesbackend.dto.TransaccionRequest;
import com.denuesto.registrotransaccionesbackend.service.TransaccionService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/transacciones")
public class TransaccionController {

    private final TransaccionService service;

    public TransaccionController(TransaccionService service) {
        this.service = service;
    }

    @GetMapping
    public List<Transaccion> listar() {
        return service.listar();
    }

    @GetMapping("/{id}")
    public Transaccion obtener(@PathVariable Long id) {
        return service.obtener(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Transaccion crear(@Valid @RequestBody TransaccionRequest request) {
        return service.crear(request);
    }

    @PutMapping("/{id}")
    public Transaccion actualizar(@PathVariable Long id, @Valid @RequestBody TransaccionRequest request) {
        return service.actualizar(id, request);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void eliminar(@PathVariable Long id) {
        service.eliminar(id);
    }
}
