package com.Banking.TransactionDetails.Controller;

import com.Banking.TransactionDetails.Entity.TransactionDetails;
import com.Banking.TransactionDetails.Entity.TransferStatements;
import com.Banking.TransactionDetails.dto.AccountDetailsDto;
import com.Banking.TransactionDetails.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TransactionController {
    @Autowired
    TransactionService transactionService;
    @GetMapping("/getTransferStatements/{accountNumber}")
    public List<TransferStatements> getTransferStatements(@PathVariable long accountNumber){
        return transactionService.getTransferStatements(accountNumber);
    }
//
//    @GetMapping("/getTransactionDetails/{accountNumber}")
//    public List<TransactionDetails> getTransactionDetails(@PathVariable long accountNumber) {
//        return transactionService.getTransactionDetails(accountNumber);
//    }
    @GetMapping("/getAccountDetails/{adharNumber}")
    public AccountDetailsDto getAccountDetails(@PathVariable long adharNumber) {
        return transactionService.fetchUserByAdharNumber(adharNumber);
    }
    @PostMapping("/updateBalance/{accountNumber}/{balance}")
    public AccountDetailsDto updateBalance(@PathVariable long accountNumber,@PathVariable double balance){
        return transactionService.updateBalance(accountNumber,balance);
    }
    @PostMapping("/Transaction")
    public TransactionDetails addTransaction(@RequestBody TransactionDetails transactionDetails) {
        return transactionService.addTransaction(transactionDetails);
    }
}
