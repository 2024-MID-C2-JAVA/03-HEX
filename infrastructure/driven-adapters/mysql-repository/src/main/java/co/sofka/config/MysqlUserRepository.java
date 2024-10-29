package co.sofka.config;

import co.sofka.data.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MysqlUserRepository extends JpaRepository<UserEntity,Integer> { }
