package co.sofka.data.transaction;

import java.math.BigDecimal;

public class TransactionResponseDTO {
    private String transactionId;
    private String transactionType;
    private BigDecimal total;

    public TransactionResponseDTO(String transactionId, String transactionType, BigDecimal total) {
        this.transactionId = transactionId;
        this.transactionType = transactionType;
        this.total = total;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    public String getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(String transactionType) {
        this.transactionType = transactionType;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }
}
