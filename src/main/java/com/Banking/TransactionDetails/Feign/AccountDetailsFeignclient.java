package com.Banking.TransactionDetails.Feign;

import com.Banking.TransactionDetails.dto.AccountDetailsDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient(name = "AccountDetails",url = "http://localhost:9001")
@Repository
public interface AccountDetailsFeignclient {
    @GetMapping("/fetchUserByAdharNumber/{adharNumber}")
    public AccountDetailsDto fetchUserByAdharNumber(@PathVariable long adharNumber);

    @GetMapping("/fetchUserByAccountNumber/{accountNumber}")
    public AccountDetailsDto fetchUserByAccountNumber(@PathVariable long accountNumber);
    @PostMapping("/updateBalance/{accountNumber}/{balance}")
    public AccountDetailsDto updateBalance(@PathVariable long accountNumber,@PathVariable double balance);
    @GetMapping("/fetchBalance/{accountNumber}")
    public double fetchBalance(@PathVariable long accountNumber);



//    @PostMapping("/fetchUserByAdharNumber")
//    public AccountDetails fetchUserByAdharNumber1(long adharNumber);
//    @PostMapping("/fetchUserByAccountNumber/{accountNumber}")
//    public AccountDetails fetchUserByAccountNumber1(@PathVariable long accountNumber);

}
