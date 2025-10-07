package com.codeLearner.Ziganya.models.contribution;

import org.springframework.stereotype.Component;

@Component
public class ContributionConverter {

    public ContributionResponse convertToResponse(Contribution contribution){
        ContributionResponse response = new ContributionResponse();
        response.setId(contribution.getId());
        response.setContributionDate(contribution.getContributionDate());
        response.setAmount(contribution.getAmount());
        response.setDescription(contribution.getDescription());
        return response;
    }

    public Contribution convertToEntity(ContributionRequest request){
        Contribution contribution = new Contribution();
        contribution.setContributionDate(request.getContributionDate());
        contribution.setAmount(request.getAmount());
        contribution.setDescription(request.getDescription());
        return contribution;
    }
}
