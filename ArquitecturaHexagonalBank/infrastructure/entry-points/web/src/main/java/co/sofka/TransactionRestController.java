package co.sofka;

import co.sofka.data.transaction.DeleteTransactionDTO;
import co.sofka.data.transaction.GetTransactionDTO;
import co.sofka.data.transaction.TransactionDTO;
import co.sofka.data.transaction.TransactionResponseDTO;
import co.sofka.handler.TransactionHandler;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/transaction")
public class TransactionRestController {

    private final TransactionHandler transactionHandler;

    public TransactionRestController(TransactionHandler transactionHandler) {
        this.transactionHandler = transactionHandler;
    }

    @PostMapping("/save")
    public ResponseEntity<TransactionResponseDTO> createTransaction(@RequestBody TransactionDTO transactionDTO) {
        transactionHandler.createTransaction(transactionDTO);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }


    @DeleteMapping("/delete")
    public ResponseEntity<TransactionResponseDTO> deleteTransaction(@RequestBody DeleteTransactionDTO dto) {
        transactionHandler.deleteTransaction(dto);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PostMapping("/get")
    public ResponseEntity<TransactionResponseDTO> getTransactionById(@RequestBody GetTransactionDTO dto) {
        return new ResponseEntity<>(transactionHandler.getTransactionById(dto), HttpStatus.OK);
    }

}
