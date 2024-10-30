package co.com.sofka;

import co.com.sofka.requests.AddTransactionRequest;
import co.com.sofka.responses.TransactionDoneResponse;
import co.com.sofka.usescases.WithdrawFromAtmUseCase;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/account")
public class WithdrawalsController {
    private final WithdrawFromAtmUseCase withdrawFromAtmUseCase;

    public WithdrawalsController(WithdrawFromAtmUseCase withdrawFromAtmUseCase) {
        this.withdrawFromAtmUseCase = withdrawFromAtmUseCase;
    }

    @PostMapping("/atm-withdrawals")
    public ResponseEntity<TransactionDoneResponse> registerAtmWithdrawal(@RequestBody AddTransactionRequest transactionRequest) {
        return ResponseEntity.ok(this.withdrawFromAtmUseCase.execute(transactionRequest));
    }
}
