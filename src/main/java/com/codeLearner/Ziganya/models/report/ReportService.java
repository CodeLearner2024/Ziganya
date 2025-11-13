package com.codeLearner.Ziganya.models.report;

import com.codeLearner.Ziganya.models.associationaccount.AssociationAccount;
import com.codeLearner.Ziganya.models.associationaccount.AssociationAccountRepository;
import com.codeLearner.Ziganya.models.contribution.Contribution;
import com.codeLearner.Ziganya.models.contribution.ContributionRepository;
import com.codeLearner.Ziganya.models.credit.CreditRepository;
import com.codeLearner.Ziganya.models.member.Member;
import com.codeLearner.Ziganya.models.member.MemberConverter;
import com.codeLearner.Ziganya.models.member.MemberRepository;
import com.codeLearner.Ziganya.models.refund.RefundRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ReportService {

    private final ContributionRepository contributionRepository;
    private final CreditRepository creditRepository;
    private final RefundRepository refundRepository;
    private final MemberRepository memberRepository;
    private final MemberConverter converter;
    private final AssociationAccountRepository associationAccountRepository;

    public ReportService(ContributionRepository contributionRepository, CreditRepository creditRepository, RefundRepository refundRepository, MemberRepository memberRepository, MemberConverter converter, AssociationAccountRepository associationAccountRepository) {
        this.contributionRepository = contributionRepository;
        this.creditRepository = creditRepository;
        this.refundRepository = refundRepository;
        this.memberRepository = memberRepository;
        this.converter = converter;
        this.associationAccountRepository = associationAccountRepository;
    }

    public List<ReportResponse> getReport() {
        List<Member> members = memberRepository.findAll();
        AssociationAccount associationAccount = associationAccountRepository.findCurrentAssociationAccount();
        double interestAmount = associationAccount.getInterestAmount();
        int totalAction = members.stream().mapToInt(Member::getManyOfActions).sum();
        double actionInterest = interestAmount / totalAction;
        List<ReportResponse> reports = new ArrayList<>();

        for (Member member : members) {
            ReportResponse report = new ReportResponse();
            report.setMemberResponse(converter.convertToResponse(member));
            report.setActions(member.getManyOfActions());
            report.setContributedAmount(contributionRepository.sumOfAmountInCurrentYearContributionsByMemberId(member.getId()));
            report.setLoanAmount(Optional.ofNullable(creditRepository.sumOfCreditedAmount(member.getId())).orElse(0.0));
            report.setRefundAmount(Optional.ofNullable(
                    refundRepository.sumRefundByMembreForCurrentYear(member.getId())
            ).orElse(0.0));
            report.setInterestAmount((double) Math.round(actionInterest * member.getManyOfActions()));
            double contributed = contributionRepository.sumOfAmountInCurrentYearContributionsByMemberId(member.getId());
            double interest = (double) Math.round(actionInterest * member.getManyOfActions());
            double noPaidAmount = (Optional.ofNullable(creditRepository.sumOfCreditedAmount(member.getId())).orElse(0.0)-Optional.ofNullable(
                    refundRepository.sumRefundByMembreForCurrentYear(member.getId())
            ).orElse(0.0));
            double total = (contributed + interest)-noPaidAmount;
            report.setTotalAmount(total);
            reports.add(report);
        }
        return reports;
    }


    public GeneralReportResponse getGeneralReport() {
        GeneralReportResponse response = new GeneralReportResponse();
        AssociationAccount associationAccount = associationAccountRepository.findCurrentAssociationAccount();
        Double contribution = contributionRepository.sumCurrentYearContributions();
        Double credit = creditRepository.sumCurrentYearCredits();
        Double totalCredit = creditRepository.sumCurrentYearCreditsTotal();

        response.setContributedAmount(contribution);
        response.setCreditedAmount(credit);
        response.setInterestAmount(totalCredit-credit);
        response.setManyofMembers(memberRepository.findAll().size());
        response.setActions(memberRepository.findAll().stream().mapToInt(Member::getManyOfActions).sum());
        response.setContributionLatePenalityAmount(contributionRepository.findAll().stream().mapToDouble(Contribution::getLatePenaltyAmount).sum());
        return response;
    }



}
