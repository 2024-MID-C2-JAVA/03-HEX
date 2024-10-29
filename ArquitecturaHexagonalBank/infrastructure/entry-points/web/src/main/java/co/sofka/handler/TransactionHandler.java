package co.sofka.handler;

import co.sofka.Transaction;
import co.sofka.TypeOfTransaction;
import co.sofka.data.transaction.DeleteTransactionDTO;
import co.sofka.data.transaction.GetTransactionDTO;
import co.sofka.data.transaction.TransactionDTO;
import co.sofka.data.transaction.TransactionResponseDTO;
import co.sofka.usecase.transaction.CreateTransactionUseCase;
import co.sofka.usecase.transaction.DeleteTransactionUseCase;
import co.sofka.usecase.transaction.GetTransactionByIdUseCase;
import org.springframework.stereotype.Component;

@Component
public class TransactionHandler {
    private final CreateTransactionUseCase createTransactionUseCase;
    private final DeleteTransactionUseCase deleteTransactionUseCase;
    private final GetTransactionByIdUseCase getTransactionByIdUseCase;


    public TransactionHandler(CreateTransactionUseCase createTransactionUseCase, DeleteTransactionUseCase deleteTransactionUseCase, GetTransactionByIdUseCase getTransactionByIdUseCase) {
        this.createTransactionUseCase = createTransactionUseCase;
        this.deleteTransactionUseCase = deleteTransactionUseCase;
        this.getTransactionByIdUseCase = getTransactionByIdUseCase;
    }

    public void createTransaction(TransactionDTO transactionDTO) {
        Transaction transaction = new Transaction();
        transaction.setUserId(transactionDTO.getUserId());
        transaction.setTotal(transactionDTO.getTotal());
        transaction.setTypeOfTransaction(TypeOfTransaction.valueOf(transactionDTO.getTransactionType()));
        transaction.setTotalAmount(transactionDTO.getTotalAmount());
        createTransactionUseCase.apply(transaction);
    }

    public void deleteTransaction(DeleteTransactionDTO dto) {
        Transaction transaction = new Transaction();
        transaction.setTransactionId(dto.getTransactionId());
        deleteTransactionUseCase.apply(transaction);
    }

    public TransactionResponseDTO getTransactionById(GetTransactionDTO dto) {
        Transaction transaction = getTransactionByIdUseCase.apply(dto.getTransactionId());
        return new TransactionResponseDTO(String.valueOf(dto.getTransactionId()),String.valueOf(transaction.getTypeOfTransaction()),transaction.getTotal());
    }
}
