package com.Banking.TransactionDetails.Repository;

import com.Banking.TransactionDetails.Entity.TransactionDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TransactionDetailsRepository extends JpaRepository<TransactionDetails, Long>{
//   @Query(value = "select * from transaction_details where account_number = ?1 order by transaction_id desc limit 10",nativeQuery = true)
//    List<TransactionDetails> listOfTenTransactions(long accountNumber);
}
