package com.picpaysimplificado.controller;

import com.picpaysimplificado.domain.transactional.Transaction;
import com.picpaysimplificado.dtos.UserSimplifiedDTO;
import com.picpaysimplificado.dtos.TransactionalDTO;
import com.picpaysimplificado.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;


@RestController
@RequestMapping("/transactions")
public class TransactionalController {

    @Autowired
    private TransactionService transactionService;

    @PostMapping
    public ResponseEntity<Transaction> createTransaction(@RequestBody TransactionalDTO transactionalDTO) throws Exception {
        Transaction newTransaction = this.transactionService.createTransaction(transactionalDTO);
        return new ResponseEntity<>(newTransaction, HttpStatus.OK);
    }

    @GetMapping("/list")
    public ResponseEntity<List<UserSimplifiedDTO>> getAllTransactions() throws Exception {
        List<Transaction> transactions = this.transactionService.getAllTransactions();
        if (transactions.isEmpty()) {
            throw new Exception("Nenhuma transação foi encontrada.");
        }

        List<UserSimplifiedDTO> myTransactions = transactions.stream()
                .flatMap(transaction -> Stream.of(
                        new UserSimplifiedDTO(
                                transaction.getSender().getId(),
                                transaction.getSender().getFirstName(),
                                transaction.getSender().getLastName(),
                                transaction.getSender().getDocument(),
                                transaction.getAmount(),
                                transaction.getSender().getBalance(),
                                transaction.getSender().getUserType(),
                                transaction.getTimeStamp(),
                                transaction.getId()
                        ),
                        new UserSimplifiedDTO(
                                transaction.getReceiver().getId(),
                                transaction.getReceiver().getFirstName(),
                                transaction.getReceiver().getLastName(),
                                transaction.getReceiver().getDocument(),
                                transaction.getAmount(),
                                transaction.getReceiver().getBalance(),
                                transaction.getReceiver().getUserType(),
                                transaction.getTimeStamp(),
                                transaction.getId()
                        )
                ))
                .collect(Collectors.toList());

        return new ResponseEntity<>(myTransactions, HttpStatus.OK);
    }
}
