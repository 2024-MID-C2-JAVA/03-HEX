package co.com.sofka;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Transaction {
    private String id;
    private final TransactionType type;
    private final BigDecimal amount;
    private final String description;
    private final BigDecimal balanceAfterTransaction;
    private final LocalDateTime dateTime;

    public Transaction(String id, TransactionType type, BigDecimal amount, String description, BigDecimal balanceAfterTransaction) {
        this.id = id;
        this.type = type;
        this.amount = amount;
        this.description = description;
        this.balanceAfterTransaction = balanceAfterTransaction;
        this.dateTime = LocalDateTime.now();
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public TransactionType getType() {
        return this.type;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public String getDescription() {
        return description;
    }

    public BigDecimal getBalanceAfterTransaction() {
        return this.balanceAfterTransaction;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }
}
