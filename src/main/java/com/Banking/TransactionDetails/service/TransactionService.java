package com.Banking.TransactionDetails.service;

import com.Banking.TransactionDetails.Entity.TransactionDetails;
import com.Banking.TransactionDetails.Entity.TransferStatements;
import com.Banking.TransactionDetails.Feign.AccountDetailsFeignclient;
import com.Banking.TransactionDetails.Repository.TransactionDetailsRepository;
import com.Banking.TransactionDetails.Repository.TransferStatementRepository;
import com.Banking.TransactionDetails.dto.AccountDetailsDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransactionService {
    @Autowired
    private TransactionDetailsRepository transactionDetailsRepository;
    @Autowired
    private TransferStatementRepository transferStatementRepository;
    @Autowired
    private AccountDetailsFeignclient ACCountDetailsFeignclient;

    public AccountDetailsDto fetchUserByAdharNumber(long adharNumber) {
        return ACCountDetailsFeignclient.fetchUserByAdharNumber(adharNumber);
    }

    public TransactionDetails addTransaction(TransactionDetails transactionDetails){
        TransferStatements transferStatements = new TransferStatements();
        AccountDetailsDto useraccountDetails = ACCountDetailsFeignclient.fetchUserByAccountNumber(transactionDetails.getAccountNumber());
        AccountDetailsDto receiverAccountDetails = ACCountDetailsFeignclient.fetchUserByAccountNumber(transactionDetails.getRecieverAccountNumber());
        if(useraccountDetails==null){
            throw new RuntimeException("Account not found");
        }
        if(receiverAccountDetails==null){
            throw new RuntimeException("Receiver Account not found");
        }
      if(transactionDetails.getTransactionType().equals("debit")){

          if(useraccountDetails.getBalance()>transactionDetails.getTransactionAmount()){

              ACCountDetailsFeignclient.updateBalance(useraccountDetails.getAccountNumber(),useraccountDetails.getBalance()-transactionDetails.getTransactionAmount());
              ACCountDetailsFeignclient.updateBalance(receiverAccountDetails.getAccountNumber(),receiverAccountDetails.getBalance()+transactionDetails.getTransactionAmount());
              double balance = ACCountDetailsFeignclient.fetchBalance(useraccountDetails.getAccountNumber());
              double recieversBalance = ACCountDetailsFeignclient.fetchBalance(receiverAccountDetails.getAccountNumber());

              TransferStatements SendertransferStatements = new TransferStatements(transactionDetails.getTransactionId(), transactionDetails.getAccountNumber(), transactionDetails.getRecieverAccountNumber(), "DEBIT", transactionDetails.getTransactionDate(), transactionDetails.getTransactionAmount(), balance);
              TransferStatements recievertransferStatements = new TransferStatements(transactionDetails.getTransactionId(), transactionDetails.getRecieverAccountNumber(), transactionDetails.getAccountNumber(), "CREDIT", transactionDetails.getTransactionDate(), transactionDetails.getTransactionAmount(), recieversBalance);
                transferStatementRepository.save(SendertransferStatements);
                transferStatementRepository.save(recievertransferStatements);
              transactionDetailsRepository.save(transactionDetails);
              System.out.println("Transaction Successfull");

          }
          else {
              throw new RuntimeException("Insufficient balance");
          }

        }
      else {
          throw new RuntimeException("Invalid Transaction Type");
      }
//        transactionDetailsRepository.save(transactionDetails);
        return transactionDetails;
    }

    public AccountDetailsDto updateBalance(long accountNumber, double balance) {
        return ACCountDetailsFeignclient.updateBalance(accountNumber,balance);
    }

//    public List<TransactionDetails> getTransactionDetails(long accountNumber) {
//        return transactionDetailsRepository.listOfTenTransactions(accountNumber);
//    }

    public List<TransferStatements> getTransferStatements(long accountNumber) {
        return transferStatementRepository.listOfTenTransferStatements(accountNumber);
    }
}
