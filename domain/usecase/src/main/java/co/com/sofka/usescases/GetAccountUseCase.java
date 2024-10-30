package co.com.sofka.usescases;

import co.com.sofka.Account;
import co.com.sofka.common.UseCase;
import co.com.sofka.gateway.AccountRepository;
import co.com.sofka.responses.GetAccountResponse;
import co.com.sofka.responses.TransactionResponse;

import java.util.Arrays;

public class GetAccountUseCase implements UseCase<Void, GetAccountResponse> {
    private final AccountRepository accountRepository;

    public GetAccountUseCase(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public GetAccountResponse execute(Void request) {
        Account account = this.accountRepository.getAccount();

        if (account == null) {
            return null;
        }

        return new GetAccountResponse(
                account.getBalance(),
                Arrays.stream(account.getTransactions()).map(
                        x -> new TransactionResponse(
                                x.getId(),
                                x.getAmount(),
                                x.getDescription(),
                                x.getBalanceAfterTransaction(),
                                x.getDateTime()
                        )
                ).toArray(TransactionResponse[]::new)
        );
    }
}
