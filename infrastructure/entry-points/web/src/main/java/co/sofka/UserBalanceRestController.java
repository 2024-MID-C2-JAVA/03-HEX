package co.sofka;

import co.sofka.data.userBalance.CreateUserBalanceDTO;
import co.sofka.data.userBalance.GetBalanceDTO;
import co.sofka.data.userBalance.UserBalanceResponseDTO;
import co.sofka.handler.UserBalanceHandler;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/userbalance")
public class UserBalanceRestController {

    private final UserBalanceHandler userBalanceHandler;

    public UserBalanceRestController(UserBalanceHandler userBalanceHandler) {
        this.userBalanceHandler = userBalanceHandler;
    }

    @PostMapping("/save")
    public ResponseEntity<UserBalanceResponseDTO>createUserBalance(@RequestBody CreateUserBalanceDTO createUserBalanceDTO) {
        userBalanceHandler.createUserBalance(createUserBalanceDTO);
        return ResponseEntity.ok(new UserBalanceResponseDTO(createUserBalanceDTO.getId(),createUserBalanceDTO.getBalance()));
    }


    @PostMapping("/get")
    public ResponseEntity<UserBalanceResponseDTO>getResponseBalanceById(@RequestBody GetBalanceDTO getBalanceDTO) {
        UserBalanceResponseDTO userBalanceResponseDTO=userBalanceHandler.getUserBalanceById(getBalanceDTO);
        return ResponseEntity.ok(userBalanceResponseDTO);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<UserBalanceResponseDTO> getUserBalanceById(@RequestBody GetBalanceDTO getBalanceDTO) {
        userBalanceHandler.deleteUserBalance(getBalanceDTO);
        return ResponseEntity.ok(new UserBalanceResponseDTO(getBalanceDTO.getId(),getBalanceDTO.getBalance()));
    }

}
