package co.sofka;

import co.sofka.config.MysqlUserRepository;
import co.sofka.data.UserEntity;
import co.sofka.gateway.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public class MysqlUserAdapter implements CrudRepository<User> {

    private final MysqlUserRepository mysqlUserRepository;

    public MysqlUserAdapter(MysqlUserRepository mysqlUserRepository) {
        this.mysqlUserRepository = mysqlUserRepository;
    }


    @Override
    public void create(User user) {
        UserEntity userEntity = new UserEntity();
        userEntity.setName(user.getName());
        mysqlUserRepository.save(userEntity);
    }

    @Override
    public void update(User user) {
        UserEntity userEntity = new UserEntity();
        userEntity.setId(Integer.parseInt(user.getUserId()));
        userEntity.setName(user.getName());
        mysqlUserRepository.save(userEntity);
    }

    @Override
    public void delete(User user) {
        UserEntity userEntity = new UserEntity();
        userEntity.setId(Integer.parseInt(user.getUserId()));
        userEntity.setName(user.getName());
        mysqlUserRepository.delete(userEntity);
    }

    @Override
    public User getById(String id) {
        UserEntity userEntity = mysqlUserRepository.findById(Integer.parseInt(id)).get();
        User user = new User();
        user.setName(userEntity.getName());
        return user;
    }

}
