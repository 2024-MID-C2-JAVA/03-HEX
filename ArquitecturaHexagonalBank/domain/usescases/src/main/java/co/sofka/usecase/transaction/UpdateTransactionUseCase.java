package co.sofka.usecase.transaction;

import co.sofka.Transaction;
import co.sofka.gateway.CrudRepository;

public class UpdateTransactionUseCase {
    private final CrudRepository<Transaction>repository;

    public UpdateTransactionUseCase(CrudRepository<Transaction>repository) {
        this.repository = repository;
    }

    public void apply(Transaction transaction) {repository.update(transaction);}
}
