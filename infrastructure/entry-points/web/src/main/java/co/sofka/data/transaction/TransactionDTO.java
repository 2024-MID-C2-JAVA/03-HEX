package co.sofka.data.transaction;

import java.math.BigDecimal;

public class TransactionDTO {

    private String transactionId;
    private String userId;
    private BigDecimal total;
    private BigDecimal totalAmount;
    private String transactionType;

    public TransactionDTO(String userId, BigDecimal total, BigDecimal totalAmount, String transactionType) {
        this.userId = userId;
        this.total = total;
        this.totalAmount = totalAmount;
        this.transactionType = transactionType;
    }

    public TransactionDTO() {
    }

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

    public String getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(String transactionType) {
        this.transactionType = transactionType;
    }


}
