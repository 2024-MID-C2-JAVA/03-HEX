package co.com.sofka.gateway;

import co.com.sofka.TransactionType;

import java.math.BigDecimal;

public interface FeesRepository {
    BigDecimal getFeeValueByTransactionType(TransactionType transactionType);
    String getFeeDescriptionByTransactionType(TransactionType transactionType);
}
