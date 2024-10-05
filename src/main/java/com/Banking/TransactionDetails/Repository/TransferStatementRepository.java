package com.Banking.TransactionDetails.Repository;

import com.Banking.TransactionDetails.Entity.TransferStatements;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TransferStatementRepository extends JpaRepository<TransferStatements, Long>{
    @Query(value = "select * from transfer_statements where account_number = ?1 order by transaction_id desc limit 10",nativeQuery = true)
    List<TransferStatements> listOfTenTransferStatements(long accountNumber);
}
