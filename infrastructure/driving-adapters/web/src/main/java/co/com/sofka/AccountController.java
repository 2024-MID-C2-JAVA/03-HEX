package co.com.sofka;

import co.com.sofka.responses.GetAccountResponse;
import co.com.sofka.usescases.GetAccountUseCase;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/account")
public class AccountController {
    private final GetAccountUseCase getAccountUseCase;

    public AccountController(GetAccountUseCase getAccountUseCase) {
        this.getAccountUseCase = getAccountUseCase;
    }

    @GetMapping("/")
    public ResponseEntity<GetAccountResponse> getAccount() {
        GetAccountResponse account = this.getAccountUseCase.execute(null);

        if (account == null) {
            return new ResponseEntity<>(HttpStatusCode.valueOf(404));
        }

        return ResponseEntity.ok(account);
    }
}
