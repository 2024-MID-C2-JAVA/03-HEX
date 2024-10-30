package com.example.banco_hexagonal_yoder.services;

import com.example.banco_hexagonal_yoder.model.dto.ResponseDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import static org.mockito.ArgumentMatchers.anyDouble;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(AccountController.class)
@ContextConfiguration(classes = {AccountController.class, CuentaServicio.class})  // Incluye la clase de servicio y controlador
public class CuentaControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CuentaServicio cuentaServicio;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testDepositoSucursal() throws Exception {
        when(cuentaServicio.depositoSucursal(anyDouble()))
                .thenReturn(new ResponseDTO("Depósito en sucursal exitoso", 1050.00));

        mockMvc.perform(post("/cuenta/deposito/sucursal")
                        .param("monto", "100"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.mensaje").value("Depósito en sucursal exitoso"))
                .andExpect(jsonPath("$.saldoActualizado").value(1050.00));
    }

    @Test
    public void testDepositoCajero() throws Exception {
        when(cuentaServicio.depositoCajero(anyDouble()))
                .thenReturn(new ResponseDTO("Depósito en cajero exitoso", 1048.00));

        mockMvc.perform(post("/cuenta/deposito/cajero")
                        .param("monto", "100"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.mensaje").value("Depósito en cajero exitoso"))
                .andExpect(jsonPath("$.saldoActualizado").value(1048.00));
    }
}
