package co.sofka.usecase.user;

import co.sofka.User;
import co.sofka.gateway.CrudRepository;

public class CreateUserUseCase {
    private final CrudRepository<User>repository;

    public CreateUserUseCase(CrudRepository<User> repository) {
        this.repository = repository;
    }

    public void apply(User user) {repository.create(user);}
}
