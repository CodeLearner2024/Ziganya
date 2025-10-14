package com.codeLearner.Ziganya.models.refund;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RefundRepository extends JpaRepository<Refund, Long> {
    @Query("SELECT c FROM Refund c WHERE c.credit.id = :creditId")
    List<Refund> findAllByCreditId(Long creditId);
}
