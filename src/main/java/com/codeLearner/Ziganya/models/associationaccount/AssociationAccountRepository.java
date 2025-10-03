package com.codeLearner.Ziganya.models.associationaccount;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Optional;

@Repository
public interface AssociationAccountRepository extends JpaRepository<AssociationAccount, Long> {
    @Query("select a from AssociationAccount a where a.cycleStartDate = :cycleStartDate and a.cycleEndDate = :cycleEndDate")
    Optional<AssociationAccount> getAssociationAccountByPeriod(LocalDate cycleStartDate, LocalDate cycleEndDate);
}
