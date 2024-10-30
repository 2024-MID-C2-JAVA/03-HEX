package com.example.banco_hexagonal_yoder.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "cuentas")
public class Account {
    @Id
    private String id;
    private String usuario;
    private String numeroCuenta;
    private double saldo;
}
