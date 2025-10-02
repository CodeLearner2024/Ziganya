package com.codeLearner.Ziganya.models.assotiationdetails;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AssociationDetailsRepository extends JpaRepository<AssociationDetails,Long> {
}
