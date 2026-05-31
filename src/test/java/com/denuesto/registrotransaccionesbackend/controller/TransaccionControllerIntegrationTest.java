package com.denuesto.registrotransaccionesbackend.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class TransaccionControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void shouldCreateAndListTransaction() throws Exception {
        String request = """
                {
                  "descripcion": "Pago servicio",
                  "monto": 1250.50,
                  "tipo": "EGRESO",
                  "fecha": "2026-05-31T10:30:00"
                }
                """;

        mockMvc.perform(post("/api/transacciones")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(request))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.id").exists())
                .andExpect(jsonPath("$.descripcion").value("Pago servicio"));

        mockMvc.perform(get("/api/transacciones"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].tipo").value("EGRESO"))
                .andExpect(jsonPath("$[0].monto").value(1250.50));
    }

    @Test
    void shouldReturnBadRequestForInvalidPayload() throws Exception {
        String invalidRequest = """
                {
                  "descripcion": "",
                  "monto": 0,
                  "tipo": "INGRESO",
                  "fecha": "2026-05-31T10:30:00"
                }
                """;

        mockMvc.perform(post("/api/transacciones")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(invalidRequest))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.descripcion").exists())
                .andExpect(jsonPath("$.monto").exists());
    }
}
