package com.codeLearner.Ziganya.models.credit;

import com.codeLearner.Ziganya.models.enums.Decision;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CreditRepository extends JpaRepository<Credit,Long> {
    @Query("SELECT c FROM Credit c WHERE c.member.id = :memberId")
    List<Credit> findByMemberId(Long memberId);

    @Query("SELECT c FROM Credit c WHERE c.member.id = :memberId AND c.creditDecision = :status")
    Credit findByMemberIdAndStatus(Long memberId, Decision status);

    @Query("select sum(totalToPay) from Credit c where FUNCTION('YEAR', c.creditDate) = FUNCTION('YEAR', CURRENT_DATE) and c.member.id = :memberId and c.creditDecision='GRANTED'")
    Double sumOfCreditedAmount(Long memberId);

    @Query("select sum(amountPaid) from Credit c where FUNCTION('YEAR', c.creditDate) = FUNCTION('YEAR', CURRENT_DATE) and c.member.id = :memberId and c.creditDecision='GRANTED'")
    Double sumOfAmountPaid(Long memberId);

    @Query("SELECT COALESCE(SUM(c.amount), 0) FROM Credit c WHERE FUNCTION('YEAR', c.creditDate) = FUNCTION('YEAR', CURRENT_DATE)")
    Double sumCurrentYearCredits();

    @Query("SELECT COALESCE(SUM(c.totalToPay), 0) FROM Credit c WHERE FUNCTION('YEAR', c.creditDate) = FUNCTION('YEAR', CURRENT_DATE)")
    Double sumCurrentYearCreditsTotal();
}
