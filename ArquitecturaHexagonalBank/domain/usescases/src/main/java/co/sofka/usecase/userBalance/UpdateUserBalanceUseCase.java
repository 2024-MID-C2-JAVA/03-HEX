package co.sofka.usecase.userBalance;

import co.sofka.UserBalance;
import co.sofka.gateway.CrudRepository;

public class UpdateUserBalanceUseCase {
    private final CrudRepository<UserBalance>repository;


    public UpdateUserBalanceUseCase(CrudRepository<UserBalance> repository) {
        this.repository = repository;
    }

    public void apply(UserBalance userBalance) {repository.update(userBalance);}
}
