package com.codeLearner.Ziganya.models.settings;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface AssociationSettingsRepository extends JpaRepository<AssociationSettings, Long> {
    @Query("SELECT a FROM AssociationSettings a WHERE a.cycleEndDate IS NULL")
    AssociationSettings fetchCurrentAssociationSettings();

}
