package co.com.sofka.responses;

import java.math.BigDecimal;

public record GetAccountResponse(
        BigDecimal balance,
        TransactionResponse[] transactions
) {
}
