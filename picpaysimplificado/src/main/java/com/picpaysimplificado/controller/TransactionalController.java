package com.picpaysimplificado.controller;

import com.picpaysimplificado.domain.transactional.Transaction;
import com.picpaysimplificado.dtos.TransactionalDTO;
import com.picpaysimplificado.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
