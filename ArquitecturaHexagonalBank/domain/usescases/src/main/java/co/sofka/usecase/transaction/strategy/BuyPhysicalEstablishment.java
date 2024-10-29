package co.sofka.usecase.transaction.strategy;

import co.sofka.Transaction;
import co.sofka.UserBalance;

import java.math.BigDecimal;

public class BuyPhysicalEstablishment implements TypeTransaction {
    @Override
    public BigDecimal movement(Transaction transaction) {
        return transaction.getTotal();
    }
}
