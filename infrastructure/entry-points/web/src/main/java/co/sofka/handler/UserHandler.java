package co.sofka.handler;

import co.sofka.User;
import co.sofka.data.user.CreateUserDTO;
import co.sofka.data.user.GetUserDTO;
import co.sofka.data.user.UserResponseDTO;
import co.sofka.usecase.user.CreateUserUseCase;
import co.sofka.usecase.user.DeleteUserUseCase;
import co.sofka.usecase.user.GetUserByIdUseCase;
import org.springframework.stereotype.Component;

@Component
public class UserHandler {

    private final GetUserByIdUseCase getUserByIdUseCase;
    private final CreateUserUseCase createUserUseCase;
    private final DeleteUserUseCase deleteUserUseCase;

    public UserHandler(GetUserByIdUseCase getUserByIdUseCase, CreateUserUseCase createUserUseCase, DeleteUserUseCase deleteUserUseCase) {
        this.getUserByIdUseCase = getUserByIdUseCase;
        this.createUserUseCase = createUserUseCase;
        this.deleteUserUseCase = deleteUserUseCase;
    }

    public UserResponseDTO getUserById(GetUserDTO userDTO) {
        User user= getUserByIdUseCase.apply(userDTO.getId());
        return new UserResponseDTO(
                user.getUserId(),
                user.getName()
        );
    }

    public void createUser(CreateUserDTO dto){
        User user=new User();
        user.setName(dto.getName());
        createUserUseCase.apply(user);
    }

    public void deleteUser(GetUserDTO userDTO){
        User user=new User();
        user.setUserId(userDTO.getId());
        deleteUserUseCase.apply(user);
    }

}
