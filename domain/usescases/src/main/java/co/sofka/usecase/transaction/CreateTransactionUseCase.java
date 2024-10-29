package co.sofka.usecase.transaction;

import co.sofka.Transaction;
import co.sofka.gateway.CrudRepository;
import co.sofka.usecase.transaction.strategy.AccountMovementContext;

public class CreateTransactionUseCase {
    private final CrudRepository<Transaction>repository;

    public CreateTransactionUseCase(CrudRepository<Transaction>repository) {
        this.repository = repository;
    }

    public void apply(Transaction transaction) {
        transaction.setTotal(transaction.getTotal());
        transaction.setTotalAmount(AccountMovementContext.accountMovement(transaction).movement(transaction));
        repository.create(transaction);
    }
}
