package com.codeLearner.Ziganya.models.credit;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CreditRepository extends JpaRepository<Credit,Long> {
    @Query("SELECT c FROM Credit c WHERE c.member.id = :memberId")
    List<Credit> findByMemberId(Long memberId);
}
