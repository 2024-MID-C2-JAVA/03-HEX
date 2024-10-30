package com.example.banco_hexagonal_yoder.mongo_repository;

import com.example.banco_hexagonal_yoder.model.Account;
import com.example.banco_hexagonal_yoder.ports.AccountRepository;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MongoAccountRepository extends MongoRepository<Account, String>, AccountRepository {
    Account findByNumeroCuenta(String numeroCuenta);
}
