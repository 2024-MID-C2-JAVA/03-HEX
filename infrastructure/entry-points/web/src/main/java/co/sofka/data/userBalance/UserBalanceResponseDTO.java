package co.sofka.data.userBalance;

import java.math.BigDecimal;

public class UserBalanceResponseDTO {
    private String id;
    private BigDecimal balance;

    public UserBalanceResponseDTO(String id, BigDecimal balance) {
        this.id = id;
        this.balance = balance;
    }

    public UserBalanceResponseDTO(){

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }
}
