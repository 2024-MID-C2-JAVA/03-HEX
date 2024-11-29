package co.com.sofka;

import co.com.sofka.gateway.AccountRepository;

public class InMemoryAccountRepository implements AccountRepository {
    private Account globalAccount = new Account();

    @Override
    public Account getAccount() {
        return new Account(this.globalAccount);
    }

    @Override
    public void saveAccount(Account account) {
        this.globalAccount = account;
    }
}
