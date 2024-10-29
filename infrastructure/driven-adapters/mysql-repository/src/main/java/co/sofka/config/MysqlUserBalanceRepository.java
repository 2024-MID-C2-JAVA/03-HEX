package co.sofka.config;

import co.sofka.data.UserBalanceEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MysqlUserBalanceRepository extends JpaRepository<UserBalanceEntity,Integer> { }
