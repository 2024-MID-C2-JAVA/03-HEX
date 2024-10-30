package com.example.banco_hexagonal_yoder.services;

import com.example.banco_hexagonal_yoder.model.dto.ResponseDTO;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.text.DecimalFormat;
import java.util.Random;

@Service
public class CuentaServicio {

    private final double costoDepositoCajero;
    private final double costoDepositoOtraCuenta;
    private final double costoDepositoSucursal;
    private final double costoCompraEstablecimiento;
    private final double costoSeguroCompraWeb;
    private final double costoRetiro;
    private final DecimalFormat decimalFormat = new DecimalFormat("#.##");
    private double saldoInicial;
    public double getSaldoInicial() {
        return saldoInicial;
    }
    public CuentaServicio(
            @Value("${app.costoDepositoCajero:2.0}") double costoDepositoCajero,
            @Value("${app.costoDepositoOtraCuenta:1.5}") double costoDepositoOtraCuenta,
            @Value("${app.costoDepositoSucursal:0.0}") double costoDepositoSucursal,
            @Value("${app.costoCompraEstablecimiento:0.0}") double costoCompraEstablecimiento,
            @Value("${app.costoSeguroCompraWeb:5.0}") double costoSeguroCompraWeb,
            @Value("${app.costoRetiro:1.0}") double costoRetiro,
            @Value("${app.saldoInicial:1000.0}") double saldoInicial) {
        this.costoDepositoCajero = costoDepositoCajero;
        this.costoDepositoOtraCuenta = costoDepositoOtraCuenta;
        this.costoDepositoSucursal = costoDepositoSucursal;
        this.costoCompraEstablecimiento = costoCompraEstablecimiento;
        this.costoSeguroCompraWeb = costoSeguroCompraWeb;
        this.costoRetiro = costoRetiro;
        this.saldoInicial = saldoInicial;
    }


    public ResponseDTO depositoSucursal(double monto) {
        double saldoActualizado = saldoInicial + monto - costoDepositoSucursal;
        String mensaje = "Depósito en sucursal exitoso";
        return new ResponseDTO(mensaje, formatDecimal(saldoActualizado));
    }

    public ResponseDTO depositoCajero(double monto) {
        double saldoActualizado = saldoInicial + monto - costoDepositoCajero;
        String mensaje = "Depósito en cajero exitoso";
        return new ResponseDTO(mensaje, formatDecimal(saldoActualizado));
    }


    public ResponseDTO depositoOtraCuenta(double monto) {
        double saldoActualizado = saldoInicial + monto - costoDepositoOtraCuenta;
        String mensaje = "Depósito desde otra cuenta exitoso";
        return new ResponseDTO(mensaje, formatDecimal(saldoActualizado));
    }

    public ResponseDTO compraEstablecimiento(double monto) {
        double saldoActualizado = saldoInicial - monto - costoCompraEstablecimiento;
        String mensaje = "Compra en establecimiento exitosa";
        return new ResponseDTO(mensaje, formatDecimal(saldoActualizado));
    }

    public ResponseDTO retiro(double monto) {
        double saldoActualizado = saldoInicial - monto - costoRetiro;
        String mensaje = "Retiro en cajero exitoso";
        return new ResponseDTO(mensaje, formatDecimal(saldoActualizado));
    }
    public ResponseDTO compraWeb(double monto) {
        double saldoActualizado = saldoInicial - monto - costoSeguroCompraWeb;
        String mensaje = "Compra en página web exitosa";
        return new ResponseDTO(mensaje, formatDecimal(saldoActualizado));
    }

    private double formatDecimal(double value) {
        return Math.round(value * 100.0) / 100.0;
    }
}
