package co.sofka.handler;

import co.sofka.UserBalance;
import co.sofka.data.user.GetUserDTO;
import co.sofka.data.userBalance.CreateUserBalanceDTO;
import co.sofka.data.userBalance.GetBalanceDTO;
import co.sofka.data.userBalance.UserBalanceResponseDTO;
import co.sofka.usecase.user.DeleteUserUseCase;
import co.sofka.usecase.userBalance.CreateUserBalanceUseCase;
import co.sofka.usecase.userBalance.DeleteUserBalanceUseCase;
import co.sofka.usecase.userBalance.GetUserBalanceByIdUseCase;
import org.springframework.stereotype.Component;

@Component
public class UserBalanceHandler {

    private final CreateUserBalanceUseCase createUserBalanceUseCase;
    private final GetUserBalanceByIdUseCase  getUserBalanceByIdUseCase;
    private final DeleteUserBalanceUseCase deleteUserBalanceUseCase;

    public UserBalanceHandler(CreateUserBalanceUseCase createUserBalanceUseCase, GetUserBalanceByIdUseCase getUserBalanceByIdUseCase, DeleteUserBalanceUseCase deleteUserBalanceUseCase) {
        this.createUserBalanceUseCase = createUserBalanceUseCase;
        this.getUserBalanceByIdUseCase = getUserBalanceByIdUseCase;
        this.deleteUserBalanceUseCase = deleteUserBalanceUseCase;
    }

    public void createUserBalance(CreateUserBalanceDTO dto){
        UserBalance userBalance = new UserBalance();
        userBalance.setUserId(dto.getId());
        userBalance.setBalance(dto.getBalance());
        createUserBalanceUseCase.apply(userBalance);
    }

    public UserBalanceResponseDTO getUserBalanceById(GetBalanceDTO dto){
        UserBalance userBalance=getUserBalanceByIdUseCase.apply(dto.getId());
        return new UserBalanceResponseDTO(dto.getId(), userBalance.getBalance());
    }

    public void deleteUserBalance(GetBalanceDTO dto){
        UserBalance userBalance=new UserBalance();
        userBalance.setUserId(dto.getId());
        deleteUserBalanceUseCase.apply(userBalance);
    }


}
