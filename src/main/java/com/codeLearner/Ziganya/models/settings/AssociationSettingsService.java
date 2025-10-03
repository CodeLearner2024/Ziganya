package com.codeLearner.Ziganya.models.settings;

import com.codeLearner.Ziganya.util.DeleteOperationResponse;

import java.util.List;

public interface AssociationSettingsService {

    public AssociationSettingsResponse createAssociationSettings(AssociationSettingsRequest associationSettingsRequest);

    public List<AssociationSettingsResponse> findAllAssociationSettings();

    public AssociationSettingsResponse updateAssociationSettings(Long id, AssociationSettingsRequest associationSettingsRequest);

    public DeleteOperationResponse deleteAssociationSettings(Long id);




}
