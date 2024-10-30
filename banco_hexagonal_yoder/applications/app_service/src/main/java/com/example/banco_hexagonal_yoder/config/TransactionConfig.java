package com.example.banco_hexagonal_yoder.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TransactionConfig {

    // Costos para depósitos
    @Value("${app.costoDepositoCajero}")
    private double costoDepositoCajero;

    @Value("${app.costoDepositoOtraCuenta}")
    private double costoDepositoOtraCuenta;

    @Value("${app.costoDepositoSucursal}")
    private double costoDepositoSucursal;

    // Costos para compras
    @Value("${app.costoCompraEstablecimiento}")
    private double costoCompraEstablecimiento;

    @Value("${app.costoSeguroCompraWeb}")
    private double costoSeguroCompraWeb;

    // Costo para retiros
    @Value("${app.costoRetiro}")
    private double costoRetiro;

    // Getters
    public double getCostoDepositoCajero() {
        return costoDepositoCajero;
    }

    public double getCostoDepositoOtraCuenta() {
        return costoDepositoOtraCuenta;
    }

    public double getCostoDepositoSucursal() {
        return costoDepositoSucursal;
    }

    public double getCostoCompraEstablecimiento() {
        return costoCompraEstablecimiento;
    }

    public double getCostoSeguroCompraWeb() {
        return costoSeguroCompraWeb;
    }

    public double getCostoRetiro() {
        return costoRetiro;
    }
}
