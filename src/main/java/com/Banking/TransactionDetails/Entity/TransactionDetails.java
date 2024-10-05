package com.Banking.TransactionDetails.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

import java.util.Date;

@Entity
@Data
public class TransactionDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long transactionId;
    private long accountNumber;
    private double transactionAmount;
    private long recieverAccountNumber;
    private String recieverAccountHolderName;

    private String transactionType;

    private Date transactionDate;


}
