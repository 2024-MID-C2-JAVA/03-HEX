package co.sofka;

import co.sofka.config.MysqlUserBalanceRepository;
import co.sofka.data.UserBalanceEntity;
import co.sofka.gateway.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public class MysqlUserBalanceAdapter implements CrudRepository<UserBalance> {

    private final MysqlUserBalanceRepository mysqlUserBalanceRepository;

    public MysqlUserBalanceAdapter(MysqlUserBalanceRepository mysqlUserBalanceRepository) {
        this.mysqlUserBalanceRepository = mysqlUserBalanceRepository;
    }

    @Override
    public void create(UserBalance userBalance) {
        UserBalanceEntity userBalanceEntity = new UserBalanceEntity();
        userBalanceEntity.setId(Integer.parseInt(userBalance.getUserId()));
        userBalanceEntity.setBalance(userBalance.getBalance());
        mysqlUserBalanceRepository.save(userBalanceEntity);
    }

    @Override
    public void update(UserBalance userBalance) {

    }

    @Override
    public void delete(UserBalance userBalance) {
        UserBalanceEntity userBalanceEntity = new UserBalanceEntity();
        userBalanceEntity.setId(Integer.parseInt(userBalance.getUserId()));
        userBalanceEntity.setBalance(userBalance.getBalance());
        mysqlUserBalanceRepository.delete(userBalanceEntity);
    }

    @Override
    public UserBalance getById(String id) {
        UserBalance userBalance = new UserBalance();
        UserBalanceEntity userBalanceEntity = mysqlUserBalanceRepository.findById(Integer.parseInt(id)).get();
        userBalance.setUserId(String.valueOf(userBalanceEntity.getId()));
        userBalance.setBalance(userBalanceEntity.getBalance());
        return userBalance;
    }
}
