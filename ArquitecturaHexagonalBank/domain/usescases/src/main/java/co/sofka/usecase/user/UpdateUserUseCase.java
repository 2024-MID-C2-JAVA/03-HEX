package co.sofka.usecase.user;

import co.sofka.User;
import co.sofka.gateway.CrudRepository;

public class UpdateUserUseCase {
    private final CrudRepository<User> repo;

    public UpdateUserUseCase(CrudRepository<User> repo) {
        this.repo = repo;
    }

    public void apply(User user) {repo.update(user);}
}
