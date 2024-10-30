package co.com.sofka.responses;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record TransactionResponse(
        String id,
        BigDecimal amount,
        String description,
        BigDecimal balanceAfterTransaction,
        LocalDateTime dateTime
) {
}
