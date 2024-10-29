package co.sofka;

import java.math.BigDecimal;

public class Transaction {

    private String transactionId;
    private String userId;
    private BigDecimal total;
    private BigDecimal totalAmount;
    private TypeOfTransaction typeOfTransaction;

    public Transaction(String userId, BigDecimal total,BigDecimal totalAmount ,TypeOfTransaction typeOfTransaction) {
        this.userId = userId;
        this.total = total;
        this.typeOfTransaction = typeOfTransaction;
        this.totalAmount = totalAmount;
    }

    public Transaction(){}

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public BigDecimal getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
    }

    public TypeOfTransaction getTypeOfTransaction() {
        return typeOfTransaction;
    }

    public void setTypeOfTransaction(TypeOfTransaction typeOfTransaction) {
        this.typeOfTransaction = typeOfTransaction;
    }
}
