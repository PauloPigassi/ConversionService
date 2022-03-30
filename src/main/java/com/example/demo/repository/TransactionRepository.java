package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.entity.Transaction;

/**
 * Repository class for {@link com.paulopigassi.conversordemoedas.model.entity.Transaction} entity
 * @author Paulo Pigassi
 */
@Repository
public interface TransactionRepository extends  JpaRepository<Transaction, Long>{

    /**
     * Verify if there is a transaction for user id
     * @param userId {@link java.lang.Long} user id
     * @return boolean
     */
    boolean existsTransactionByUserCode(Long userCode);

    /**
     * Find all Transactions by user id
     * @param userId {@link java.lang.Long} user id
     * @return {@link java.util.List}
     */
    List<Transaction> findAllByUserCode(Long userCode);

}
