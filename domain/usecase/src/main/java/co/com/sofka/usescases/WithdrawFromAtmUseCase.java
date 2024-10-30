package co.com.sofka.usescases;

import co.com.sofka.TransactionType;
import co.com.sofka.common.TransactionManager;
import co.com.sofka.common.UseCase;
import co.com.sofka.requests.AddTransactionRequest;
import co.com.sofka.responses.TransactionDoneResponse;

public class WithdrawFromAtmUseCase implements UseCase<AddTransactionRequest, TransactionDoneResponse> {
    private final TransactionManager transactionManager;

    public WithdrawFromAtmUseCase(TransactionManager transactionManager) {
        this.transactionManager = transactionManager;
    }

    @Override
    public TransactionDoneResponse execute(AddTransactionRequest request) {
        return transactionManager.processTransaction(request.amount(), TransactionType.ATM_WITHDRAWAL);
    }
}
