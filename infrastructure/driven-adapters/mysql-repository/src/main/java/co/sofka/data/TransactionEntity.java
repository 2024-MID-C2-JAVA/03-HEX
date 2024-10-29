package co.sofka.data;

import co.sofka.TypeOfTransaction;
import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name = "transactions")
public class TransactionEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int transactionId;
    private int userId;
    private BigDecimal total;
    private BigDecimal totalAmount;
    @Enumerated(EnumType.STRING)
    private TypeOfTransaction transactionType;

    public int getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(int transactionId) {
        this.transactionId = transactionId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
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

    public TypeOfTransaction getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(TypeOfTransaction transactionType) {
        this.transactionType = transactionType;
    }


}
