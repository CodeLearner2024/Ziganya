package com.codeLearner.Ziganya.models.refund;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RefundRepository extends JpaRepository<Refund, Long> {
    @Query("SELECT c FROM Refund c WHERE c.credit.id = :creditId")
    List<Refund> findAllByCreditId(Long creditId);

    @Query("""
    SELECT SUM(r.amount)
    FROM Refund r
    JOIN r.credit c
    JOIN c.member m
    WHERE FUNCTION('YEAR', r.refundDate) = FUNCTION('YEAR', CURRENT_DATE)
      AND m.id = :idMembre AND c.creditDecision='GRANTED'
""")
    Double sumRefundByMembreForCurrentYear(@Param("idMembre") Long idMembre);
}
