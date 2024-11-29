package co.com.sofka.usescases;

import co.com.sofka.TransactionType;
import co.com.sofka.common.TransactionManager;
import co.com.sofka.common.UseCase;
import co.com.sofka.requests.AddTransactionRequest;
import co.com.sofka.responses.TransactionDoneResponse;

public class DepositFromExternalAccountUseCase implements UseCase<AddTransactionRequest, TransactionDoneResponse> {
    private final TransactionManager transactionManager;

    public DepositFromExternalAccountUseCase(TransactionManager transactionManager) {
        this.transactionManager = transactionManager;
    }

    @Override
    public TransactionDoneResponse execute(AddTransactionRequest request) {
        return transactionManager.processTransaction(request.amount(), TransactionType.EXTERNAL_DEPOSIT);
    }
}
