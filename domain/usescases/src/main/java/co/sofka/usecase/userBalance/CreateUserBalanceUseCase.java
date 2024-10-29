package co.sofka.usecase.userBalance;

import co.sofka.UserBalance;
import co.sofka.gateway.CrudRepository;

public class CreateUserBalanceUseCase {

    private final CrudRepository<UserBalance>repository;

    public CreateUserBalanceUseCase(CrudRepository<UserBalance>repository) {
        this.repository = repository;
    }

    public void apply(UserBalance userBalance) {repository.create(userBalance);}
}
