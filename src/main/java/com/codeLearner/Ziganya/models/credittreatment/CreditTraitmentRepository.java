package com.codeLearner.Ziganya.models.credittreatment;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CreditTraitmentRepository extends JpaRepository<CreditTraitment,Long> {
}
