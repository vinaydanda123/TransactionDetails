package com.Banking.TransactionDetails.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TransferStatements {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private long transactionId;
    private long accountNumber;
    private long toAccountNumber;
    private String transactionType;
    private Date transactionDate;
    private double updatedBalance;
    private double transactionAmount;

    public TransferStatements(long transactionId, long accountNumber, long toAccountNumber, String transactionType, Date transactionDate, double updatedBalance, double transactionAmount) {
        this.transactionId = transactionId;
        this.accountNumber = accountNumber;
        this.toAccountNumber = toAccountNumber;
        this.transactionType = transactionType;
        this.transactionDate = transactionDate;
        this.updatedBalance = updatedBalance;
        this.transactionAmount = transactionAmount;
    }
}
