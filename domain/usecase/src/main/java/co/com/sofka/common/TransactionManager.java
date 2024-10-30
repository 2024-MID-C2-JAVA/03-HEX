package co.com.sofka.common;

import co.com.sofka.Account;
import co.com.sofka.Transaction;
import co.com.sofka.TransactionType;
import co.com.sofka.exceptions.MinimumAmountNotReachedException;
import co.com.sofka.factories.TransactionFactory;
import co.com.sofka.gateway.AccountRepository;
import co.com.sofka.gateway.FeesRepository;
import co.com.sofka.responses.TransactionDoneResponse;

import java.math.BigDecimal;

public class TransactionManager {
    private final AccountRepository accountRepository;
    private final FeesRepository feesRepository;
    private final TransactionFactory transactionFactory;

    public TransactionManager(AccountRepository accountRepository, FeesRepository feesRepository, TransactionFactory transactionFactory) {
        this.accountRepository = accountRepository;
        this.feesRepository = feesRepository;
        this.transactionFactory = transactionFactory;
    }

    private void applyTransactionToAccount(Account account, BigDecimal amount, TransactionType transactionType, String description) {
        account.transactAmount(amount);
        Transaction transaction = this.transactionFactory.createTransaction(
                null,
                transactionType,
                amount,
                description,
                account.getBalance()
        );
        account.addTransaction(transaction);
    }

    public TransactionDoneResponse processTransaction(BigDecimal amount, TransactionType transactionType) {
        BigDecimal fee = this.feesRepository.getFeeValueByTransactionType(transactionType);

        if (amount.compareTo(BigDecimal.ZERO) > 0 && fee.abs().compareTo(amount) > 0) {
            throw new MinimumAmountNotReachedException("The amount for this transaction should be greater than $" + fee);
        }

        String transactionDescription = this.feesRepository.getFeeDescriptionByTransactionType(transactionType);

        Account account = this.accountRepository.getAccount();
        this.applyTransactionToAccount(account, amount, transactionType, transactionDescription);

        if (fee.abs().compareTo(BigDecimal.ZERO) > 0) {
            String feeDescription = this.feesRepository.getFeeDescriptionByTransactionType(TransactionType.FEE) + " | " + transactionDescription;
            this.applyTransactionToAccount(account, fee, TransactionType.FEE, feeDescription);
        }

        accountRepository.saveAccount(account);

        return new TransactionDoneResponse(
                "Transaction was successful!",
                account.getBalance()
        );
    }
}
