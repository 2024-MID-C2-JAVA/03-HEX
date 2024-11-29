package co.com.sofka.gateway;

import co.com.sofka.Account;

public interface AccountRepository {
    Account getAccount();
    void saveAccount(Account account);
}
