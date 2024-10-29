package co.sofka;

import co.sofka.config.MysqlTransactionRepository;
import co.sofka.data.TransactionEntity;
import co.sofka.gateway.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public class MysqlTransactionAdapter implements CrudRepository<Transaction> {

    private final MysqlTransactionRepository mysqlTransactionRepository;

    public MysqlTransactionAdapter(MysqlTransactionRepository mysqlTransactionRepository) {
        this.mysqlTransactionRepository = mysqlTransactionRepository;
    }

    @Override
    public void create(Transaction transaction) {
        TransactionEntity transactionEntity = new TransactionEntity();
        transactionEntity.setUserId(Integer.parseInt(transaction.getUserId()));
        transactionEntity.setTotal(transaction.getTotal());
        transactionEntity.setTotalAmount(transaction.getTotalAmount());
        transactionEntity.setTransactionType(transaction.getTypeOfTransaction());
        mysqlTransactionRepository.save(transactionEntity);
    }

    @Override
    public void update(Transaction transaction) {

    }

    @Override
    public void delete(Transaction transaction) {
        TransactionEntity transactionEntity = new TransactionEntity();
        transactionEntity.setTransactionId(Integer.parseInt(transaction.getTransactionId()));
        mysqlTransactionRepository.delete(transactionEntity);
    }

    @Override
    public Transaction getById(String id) {
        TransactionEntity entity=mysqlTransactionRepository.findById(Integer.parseInt(id)).get();
        return new Transaction(String.valueOf(entity.getUserId()),entity.getTotal(),entity.getTotalAmount(),entity.getTransactionType());
    }
}
