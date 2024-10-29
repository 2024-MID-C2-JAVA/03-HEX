package co.sofka.usecase.transaction;

import co.sofka.Transaction;
import co.sofka.gateway.CrudRepository;

public class DeleteTransactionUseCase {
    private final CrudRepository<Transaction>repository;

    public DeleteTransactionUseCase(CrudRepository<Transaction>repository) {
        this.repository = repository;
    }

    public void apply(Transaction transaction) {repository.delete(transaction);}
}
