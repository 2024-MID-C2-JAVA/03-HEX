package co.sofka.config;

import co.sofka.data.TransactionEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MysqlTransactionRepository extends JpaRepository<TransactionEntity,Integer> {}
