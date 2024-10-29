package co.sofka;

import co.sofka.data.user.CreateUserDTO;
import co.sofka.data.user.GetUserDTO;
import co.sofka.data.user.UserResponseDTO;
import co.sofka.handler.UserHandler;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")
public class UserRestController {

    private final UserHandler userHandler;

    public UserRestController(UserHandler userHandler) {
        this.userHandler = userHandler;
    }

    @PostMapping("/get")
    public ResponseEntity<UserResponseDTO>getUserById(@RequestBody GetUserDTO dto){
        UserResponseDTO userResponseDTO = userHandler.getUserById(dto);
        return new ResponseEntity<>(userResponseDTO, HttpStatus.OK);
    }

    @PostMapping("/save")
    public ResponseEntity<UserResponseDTO>createUser(@RequestBody CreateUserDTO dto){
        userHandler.createUser(dto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<UserResponseDTO>deleteUser(@RequestBody GetUserDTO dto){
        userHandler.deleteUser(dto);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
