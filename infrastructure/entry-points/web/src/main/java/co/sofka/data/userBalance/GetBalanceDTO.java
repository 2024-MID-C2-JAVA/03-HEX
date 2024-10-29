package co.sofka.data.userBalance;

import java.math.BigDecimal;

public class GetBalanceDTO {
    private String id;
    private BigDecimal balance;

    public GetBalanceDTO(String id,BigDecimal balance) {
        this.id=id;
        this.balance = balance;
    }

    public GetBalanceDTO() {}

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
