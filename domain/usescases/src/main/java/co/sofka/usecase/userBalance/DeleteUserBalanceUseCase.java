package co.sofka.usecase.userBalance;

import co.sofka.UserBalance;
import co.sofka.gateway.CrudRepository;

public class DeleteUserBalanceUseCase {
    private final CrudRepository<UserBalance>repository;

    public DeleteUserBalanceUseCase(CrudRepository<UserBalance>repository) {
        this.repository = repository;
    }

    public void apply(UserBalance userBalance) {repository.delete(userBalance);}
}
