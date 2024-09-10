package id.bca.co.intra.mini_project.service;

import id.bca.co.intra.mini_project.entity.Transaction;
import id.bca.co.intra.mini_project.repository.TransactionRepository;
import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.MeterRegistry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TransactionService {

    @Autowired
    private TransactionRepository transactionRepository;
    
    private final Counter transactionCounter;

    @Autowired
    public TransactionService(MeterRegistry meterRegistry) {
        // Mendaftarkan custom metric untuk menghitung transaksi
        this.transactionCounter = meterRegistry.counter("transaction.count");
    }

    public Transaction save(Transaction transaction){
        Transaction savedTransaction = transactionRepository.save(transaction);
        transactionCounter.increment();
        return savedTransaction;
    }

    public List<Transaction> findAll(){
        return transactionRepository.findAll();
    }

    public Optional<Transaction> findById(Long id){
        return transactionRepository.findById(id);
    }

}
