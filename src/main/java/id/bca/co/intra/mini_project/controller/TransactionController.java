package id.bca.co.intra.mini_project.controller;

import id.bca.co.intra.mini_project.dto.InsertTransactionDTO;
import id.bca.co.intra.mini_project.entity.Transaction;
import id.bca.co.intra.mini_project.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/transaction")
public class TransactionController {

    @Autowired
    private TransactionService transactionService;

    @PostMapping("/insert")
    private ResponseEntity<Object> insertNewTransaction(@RequestBody InsertTransactionDTO request){
        Transaction transaction = new Transaction();
        transaction.setTran_date(request.getTran_date());
        transaction.setAmount(request.getAmount());
        transaction.setTran_type(request.getTran_type());
        transaction.setNorek_asal(request.getNorek_asal());
        transaction.setNorek_tujuan(request.getNorek_tujuan());
        transaction.setNotes(request.getNotes());

        // Menyimpan entitas ke dalam database
        transactionService.save(transaction);

        // Mengembalikan respons sukses
        return new ResponseEntity<>("Transaction successfully inserted", HttpStatus.CREATED);
    }

    @GetMapping
    public List<Transaction> getAllTransactions() {
        return transactionService.findAll();  // Call the non-static method
    }

    @GetMapping("/{id}")
    public ResponseEntity<Transaction> getTransactionById(@PathVariable Long id) {
        Optional<Transaction> transaction = transactionService.findById(id);
        return transaction.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }
}
