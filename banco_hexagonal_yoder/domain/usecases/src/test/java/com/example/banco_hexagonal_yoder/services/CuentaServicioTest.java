package com.example.banco_hexagonal_yoder.services;

import com.example.banco_hexagonal_yoder.model.dto.ResponseDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CuentaServicioTest {

    private CuentaServicio cuentaServicio;
    private final double saldoInicial = 1000.0; // Definir un saldo inicial constante

    @BeforeEach
    void setUp() {
        cuentaServicio = new CuentaServicio(
                2.0,  // costoDepositoCajero
                1.5,  // costoDepositoOtraCuenta
                0.0,  // costoDepositoSucursal
                0.0,  // costoCompraEstablecimiento
                5.0,  // costoSeguroCompraWeb
                1.0,  // costoRetiro
                saldoInicial  // Usamos el saldo inicial controlado
        );
    }

    @Test
    void testDepositoSucursal() {
        double monto = 500;
        ResponseDTO response = cuentaServicio.depositoSucursal(monto);
        double expectedSaldo = saldoInicial + monto - 0.0;
        assertEquals("Depósito en sucursal exitoso", response.getMensaje());
        assertEquals(expectedSaldo, response.getSaldoActualizado(), 0.01);
    }

    @Test
    void testDepositoCajero() {
        double monto = 500;
        ResponseDTO response = cuentaServicio.depositoCajero(monto);
        double expectedSaldo = saldoInicial + monto - 2.0;
        assertEquals("Depósito en cajero exitoso", response.getMensaje());
        assertEquals(expectedSaldo, response.getSaldoActualizado(), 0.01);
    }

    @Test
    void testDepositoOtraCuenta() {
        double monto = 500;
        ResponseDTO response = cuentaServicio.depositoOtraCuenta(monto);
        double expectedSaldo = saldoInicial + monto - 1.5;
        assertEquals("Depósito desde otra cuenta exitoso", response.getMensaje());
        assertEquals(expectedSaldo, response.getSaldoActualizado(), 0.01);
    }

    @Test
    void testCompraEstablecimiento() {
        double monto = 500;
        ResponseDTO response = cuentaServicio.compraEstablecimiento(monto);
        double expectedSaldo = saldoInicial - monto - 0.0;
        assertEquals("Compra en establecimiento exitosa", response.getMensaje());
        assertEquals(expectedSaldo, response.getSaldoActualizado(), 0.01);
    }

    @Test
    void testCompraWeb() {
        double monto = 500;
        ResponseDTO response = cuentaServicio.compraWeb(monto);
        double expectedSaldo = saldoInicial - monto - 5.0;
        assertEquals("Compra en página web exitosa", response.getMensaje());
        assertEquals(expectedSaldo, response.getSaldoActualizado(), 0.01);
    }

    @Test
    void testRetiro() {
        double monto = 500;
        ResponseDTO response = cuentaServicio.retiro(monto);
        double expectedSaldo = saldoInicial - monto - 1.0;
        assertEquals("Retiro en cajero exitoso", response.getMensaje());
        assertEquals(expectedSaldo, response.getSaldoActualizado(), 0.01);
    }
}
