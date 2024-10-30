package co.sofka.data.userBalance;

import java.math.BigDecimal;

public class CreateUserBalanceDTO {
    private String id;
    private BigDecimal balance;

    public CreateUserBalanceDTO(String id, BigDecimal balance) {
        this.id = id;
        this.balance = balance;
    }

    public CreateUserBalanceDTO(){}

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
