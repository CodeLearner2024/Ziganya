package com.codeLearner.Ziganya.models.contribution;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ContributionRepository extends JpaRepository<Contribution, Long> {

    @Query("SELECT c FROM Contribution c WHERE c.member.id = :memberId")
    List<Contribution> getContributionsByMemberId(Long memberId);
}
