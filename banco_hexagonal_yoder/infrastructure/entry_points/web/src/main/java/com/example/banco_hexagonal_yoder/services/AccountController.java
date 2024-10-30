package com.example.banco_hexagonal_yoder.services;

import com.example.banco_hexagonal_yoder.model.dto.ResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cuenta")
public class AccountController {

    private final CuentaServicio cuentaServicio;

    @Autowired
    public AccountController(CuentaServicio cuentaServicio) {
        this.cuentaServicio = cuentaServicio;
    }
    @PostMapping("/deposito/sucursal")
    public ResponseEntity<ResponseDTO> depositoSucursal(@RequestParam double monto) {
        return ResponseEntity.ok(cuentaServicio.depositoSucursal(monto));
    }

    @PostMapping("/deposito/cajero")
    public ResponseEntity<ResponseDTO> depositoCajero(@RequestParam double monto) {
        return ResponseEntity.ok(cuentaServicio.depositoCajero(monto));
    }

    @PostMapping("/deposito/otraCuenta")
    public ResponseEntity<ResponseDTO> depositoOtraCuenta(@RequestParam double monto) {
        return ResponseEntity.ok(cuentaServicio.depositoOtraCuenta(monto));
    }

    @PostMapping("/compra/establecimiento")
    public ResponseEntity<ResponseDTO> compraEstablecimiento(@RequestParam double monto) {
        return ResponseEntity.ok(cuentaServicio.compraEstablecimiento(monto));
    }

    @PostMapping("/compra/web")
    public ResponseEntity<ResponseDTO> compraWeb(@RequestParam double monto) {
        return ResponseEntity.ok(cuentaServicio.compraWeb(monto));
    }

    @PostMapping("/retiro/cajero")
    public ResponseEntity<ResponseDTO> retiroCajero(@RequestParam double monto) {
        return ResponseEntity.ok(cuentaServicio.retiro(monto));
    }
}
