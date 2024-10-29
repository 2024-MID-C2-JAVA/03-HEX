package co.sofka.usecase.user;

import co.sofka.User;
import co.sofka.gateway.CrudRepository;

public class GetUserByIdUseCase {
    private final CrudRepository<User> repository;

    public GetUserByIdUseCase(CrudRepository<User> repository) {
        this.repository = repository;
    }

    public User apply(String id) {return repository.getById(id);}
}
