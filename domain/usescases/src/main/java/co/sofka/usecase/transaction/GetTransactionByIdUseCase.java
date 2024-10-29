package co.sofka.usecase.transaction;

import co.sofka.Transaction;
import co.sofka.gateway.CrudRepository;

public class GetTransactionByIdUseCase {
    private final CrudRepository<Transaction>repository;

    public GetTransactionByIdUseCase(CrudRepository<Transaction>repository) {
        this.repository = repository;
    }

    public Transaction apply(String id) {return repository.getById(id);}
}
