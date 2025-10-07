package com.codeLearner.Ziganya.models.contribution;

import com.codeLearner.Ziganya.util.DeleteOperationResponse;

import java.util.List;

public interface ContributionService {

    public ContributionResponse createContribution(ContributionRequest request);
    public List<ContributionResponse> getAllContributions();
    public ContributionResponse getContributionById(Long id);
    public ContributionResponse updateContribution(Long id, ContributionRequest request);
    public DeleteOperationResponse deleteContribution(Long id);
    public List<ContributionResponse> getContributionsByMemberId(Long memberId);
}
