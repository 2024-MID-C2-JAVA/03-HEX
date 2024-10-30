package co.com.sofka;

import co.com.sofka.requests.AddTransactionRequest;
import co.com.sofka.responses.TransactionDoneResponse;
import co.com.sofka.usescases.PurchaseInOnlineStoreUseCase;
import co.com.sofka.usescases.PurchaseInPhysicalStoreUseCase;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/account")
public class PurchasesController {
    private final PurchaseInOnlineStoreUseCase purchaseInOnlineStoreUseCase;
    private final PurchaseInPhysicalStoreUseCase purchaseInPhysicalStoreUseCase;

    public PurchasesController(PurchaseInOnlineStoreUseCase purchaseInOnlineStoreUseCase, PurchaseInPhysicalStoreUseCase purchaseInPhysicalStoreUseCase) {
        this.purchaseInOnlineStoreUseCase = purchaseInOnlineStoreUseCase;
        this.purchaseInPhysicalStoreUseCase = purchaseInPhysicalStoreUseCase;
    }

    @PostMapping("/physical-purchases")
    public ResponseEntity<TransactionDoneResponse> registerPhysicalPurchase(@RequestBody AddTransactionRequest transactionRequest) {
        return ResponseEntity.ok(this.purchaseInPhysicalStoreUseCase.execute(transactionRequest));
    }

    @PostMapping("/online-purchases")
    public ResponseEntity<TransactionDoneResponse> registerOnlinePurchase(@RequestBody AddTransactionRequest transactionRequest) {
        return ResponseEntity.ok(this.purchaseInOnlineStoreUseCase.execute(transactionRequest));
    }
}
