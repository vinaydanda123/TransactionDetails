package com.Banking.TransactionDetails.dto;

import lombok.Data;

@Data
public class AccountDetailsDto {
    private long accountNumber;
    private long adharNumber;
    private  String accountHolderName;
    private String accountType;
    private double balance;
    private String branchName;
    private String ifscCode;
    private long phoneNumber;
}
