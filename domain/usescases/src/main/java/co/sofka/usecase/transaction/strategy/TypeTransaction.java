package co.sofka.usecase.transaction.strategy;

import co.sofka.Transaction;

import java.math.BigDecimal;

public interface TypeTransaction {
    BigDecimal movement(Transaction transaction);
}
