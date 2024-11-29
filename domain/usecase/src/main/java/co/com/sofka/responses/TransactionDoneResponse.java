package co.com.sofka.responses;

import java.math.BigDecimal;

public record TransactionDoneResponse(
        String message,
        BigDecimal balance
) {
}
