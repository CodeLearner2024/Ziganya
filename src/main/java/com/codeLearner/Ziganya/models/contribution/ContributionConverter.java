package com.codeLearner.Ziganya.models.contribution;

import com.codeLearner.Ziganya.models.member.MemberConverter;
import org.springframework.stereotype.Component;

@Component
public class ContributionConverter {
    private final MemberConverter memberConverter;

    public ContributionConverter(MemberConverter memberConverter) {
        this.memberConverter = memberConverter;
    }

    public ContributionResponse convertToResponse(Contribution contribution){
        ContributionResponse response = new ContributionResponse();
        response.setId(contribution.getId());
        response.setContributionDate(contribution.getContributionDate());
        response.setAmount(contribution.getAmount());
        response.setDescription(contribution.getDescription());
        response.setMember(memberConverter.convertToResponse(contribution.getMember()));
        response.setLatePenaltyAmount(contribution.getLatePenaltyAmount());
        response.setMonth(contribution.getMonth());
        response.setStatus(contribution.getStatus());
        response.setStatus(contribution.getStatus());
        return response;
    }

    public Contribution convertToEntity(ContributionRequest request){
        Contribution contribution = new Contribution();
        contribution.setContributionDate(request.getContributionDate());
        contribution.setAmount(request.getAmount());
        contribution.setDescription(request.getDescription());
        contribution.setMonth(request.getMonth());
        contribution.setStatus(request.getStatus());
//        contribution.setLatePenaltyAmount(request.getLatePenaltyAmount());
        contribution.setStatus(request.getStatus());
        return contribution;
    }
}
