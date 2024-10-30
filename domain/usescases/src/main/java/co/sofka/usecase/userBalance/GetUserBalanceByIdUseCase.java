package co.sofka.usecase.userBalance;

import co.sofka.UserBalance;
import co.sofka.gateway.CrudRepository;

public class GetUserBalanceByIdUseCase {
    private final CrudRepository<UserBalance>repository;

    public GetUserBalanceByIdUseCase(CrudRepository<UserBalance> repository) {
        this.repository = repository;
    }

    public UserBalance apply(String id) {return repository.getById(id);}
}
