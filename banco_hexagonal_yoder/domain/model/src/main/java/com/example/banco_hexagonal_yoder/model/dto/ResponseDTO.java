package com.example.banco_hexagonal_yoder.model.dto;



public class ResponseDTO {
    private String mensaje;
    private double saldoActualizado;

    public ResponseDTO(String mensaje, double saldoActualizado) {
        this.mensaje = mensaje;
        this.saldoActualizado = saldoActualizado;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public double getSaldoActualizado() {
        return saldoActualizado;
    }

    public void setSaldoActualizado(double saldoActualizado) {
        this.saldoActualizado = saldoActualizado;
    }
}
