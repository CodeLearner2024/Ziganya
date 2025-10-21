package com.codeLearner.Ziganya.models.contribution;

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
    Contribution getContributionByEmployeeIdAndMonth(Long memberId, Month month);

    @Query("SELECT COALESCE(SUM(c.amount), 0) FROM Contribution c WHERE FUNCTION('YEAR', c.contributionDate) = FUNCTION('YEAR', CURRENT_DATE)")
    Double sumCurrentYearContributions();

    boolean existsByMemberId(Long memberId);
}
