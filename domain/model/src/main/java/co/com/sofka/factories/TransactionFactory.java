package co.com.sofka.factories;

import co.com.sofka.Transaction;
import co.com.sofka.TransactionType;

import java.math.BigDecimal;

public class TransactionFactory {
    public Transaction createTransaction(
            String id,
            TransactionType type,
            BigDecimal amount,
            String description,
            BigDecimal balanceAfterTransaction
    ) {
        return new Transaction(id, type, amount, description, balanceAfterTransaction);
    }
}
