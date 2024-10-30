package co.com.sofka;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.LinkedList;
import java.util.List;

public class Account {
    private BigDecimal balance;
    private final List<Transaction> transactions;

    public Account() {
        this.balance = BigDecimal.ZERO.setScale(2, RoundingMode.HALF_UP);
        this.transactions = new LinkedList<>();
    }

    public Account(Account other) {
        if (other == null) {
            throw new IllegalArgumentException("The provided account is null");
        }

        this.balance = other.balance;
        this.transactions = new LinkedList<>(other.transactions);
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public Transaction[] getTransactions() {
        return transactions.toArray(Transaction[]::new);
    }

    public void addTransaction(Transaction transaction) {
        this.transactions.addFirst(transaction);
    }
}
