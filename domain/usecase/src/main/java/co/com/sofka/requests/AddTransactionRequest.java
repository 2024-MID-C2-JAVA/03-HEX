package co.com.sofka.requests;

import java.math.BigDecimal;

public record AddTransactionRequest(
        BigDecimal amount
) {
}
