package co.sofka.usecase.user;

import co.sofka.User;
import co.sofka.gateway.CrudRepository;

public class DeleteUserUseCase {
    private final CrudRepository<User>repository;

    public DeleteUserUseCase(CrudRepository<User>repository) {
        this.repository = repository;
    }

    public void apply(User user) {repository.delete(user);}
}
