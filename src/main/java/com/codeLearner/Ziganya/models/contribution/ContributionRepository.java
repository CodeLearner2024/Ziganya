package com.codeLearner.Ziganya.models.contribution;

import com.codeLearner.Ziganya.models.enums.ContributionStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.Month;
import java.util.List;

@Repository
public interface ContributionRepository extends JpaRepository<Contribution, Long> {

    @Query("SELECT c FROM Contribution c WHERE c.member.id = :memberId")
    List<Contribution> getContributionsByMemberId(Long memberId);

    @Query("SELECT c FROM Contribution c WHERE c.member.id = :memberId AND c.month = :month")
    List<Contribution> getContributionByEmployeeIdAndMonth(Long memberId, Month month);

    @Query("SELECT COALESCE(SUM(c.amount), 0) FROM Contribution c WHERE FUNCTION('YEAR', c.contributionDate) = FUNCTION('YEAR', CURRENT_DATE)")
    Double sumCurrentYearContributions();

    boolean existsByMemberId(Long memberId);

    boolean existsByMemberIdAndStatus(Long memberId, ContributionStatus status);

    @Query("select sum(c.amount) from Contribution c where EXTRACT(YEAR FROM c.contributionDate) = EXTRACT(YEAR FROM CURRENT_DATE) and c.member.id = :memberId")
    Double sumOfAmountInCurrentYearContributionsByMemberId(Long memberId);

    @Query("SELECT COUNT(c) > 0 FROM Contribution c WHERE c.member.id = :memberId AND c.month = :month")
    boolean existsByMemberIdAndMonth(Long memberId,Month  month);
}
