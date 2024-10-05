package com.Banking.TransactionDetails.service;

import com.Banking.TransactionDetails.Entity.TransferStatements;
import com.Banking.TransactionDetails.Repository.TransferStatementRepository;

public class TransferStatementService {
    private TransferStatementRepository transferStatementRepository;

    public TransferStatements saveTransferStatement(TransferStatements transferStatements) {
        return transferStatementRepository.save(transferStatements);
    }
}
