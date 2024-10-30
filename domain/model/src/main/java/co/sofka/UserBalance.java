package co.sofka;

import java.math.BigDecimal;

public class UserBalance {
    private String userId;
    private BigDecimal balance;

    public UserBalance(String userId, BigDecimal balance) {
        this.userId = userId;
        this.balance = balance;
    }

    public UserBalance() {}

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }
}
