package com.example.banco_hexagonal_yoder.ports;
import com.example.banco_hexagonal_yoder.model.Account;

public interface AccountRepository {
    Account save(Account account);
    Account findByNumeroCuenta(String numeroCuenta);
}
