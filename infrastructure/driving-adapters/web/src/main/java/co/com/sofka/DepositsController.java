package co.com.sofka;

import co.com.sofka.exceptions.MinimumAmountNotReachedException;
import co.com.sofka.requests.AddTransactionRequest;
import co.com.sofka.responses.TransactionDoneResponse;
import co.com.sofka.usescases.DepositFromAtmUseCase;
import co.com.sofka.usescases.DepositFromBranchUseCase;
import co.com.sofka.usescases.DepositFromExternalAccountUseCase;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/account")
public class DepositsController {
    private final DepositFromBranchUseCase depositFromBranchUseCase;
    private final DepositFromAtmUseCase depositFromAtmUseCase;
    private final DepositFromExternalAccountUseCase depositFromExternalAccountUseCase;

    public DepositsController(DepositFromBranchUseCase depositFromBranchUseCase, DepositFromAtmUseCase depositFromAtmUseCase, DepositFromExternalAccountUseCase depositFromExternalAccountUseCase) {
        this.depositFromBranchUseCase = depositFromBranchUseCase;
        this.depositFromAtmUseCase = depositFromAtmUseCase;
        this.depositFromExternalAccountUseCase = depositFromExternalAccountUseCase;
    }

    @PostMapping("/branch-deposits")
    public ResponseEntity<TransactionDoneResponse> registerBranchDeposit(@RequestBody AddTransactionRequest transactionRequest) {
        return ResponseEntity.ok(this.depositFromBranchUseCase.execute(transactionRequest));
    }

    @PostMapping("/atm-deposits")
    public ResponseEntity<TransactionDoneResponse> registerAtmDeposit(@RequestBody AddTransactionRequest transactionRequest) {
        return ResponseEntity.ok(this.depositFromAtmUseCase.execute(transactionRequest));
    }

    @PostMapping("/external-deposits")
    public ResponseEntity<TransactionDoneResponse> registerExternalDeposit(@RequestBody AddTransactionRequest transactionRequest) {
        return ResponseEntity.ok(this.depositFromExternalAccountUseCase.execute(transactionRequest));
    }

    @ExceptionHandler(MinimumAmountNotReachedException.class)
    public ResponseEntity<String> handleMinimumAmountNotReachedException(MinimumAmountNotReachedException e) {
        return ResponseEntity.badRequest().body(e.getMessage());
    }
}
