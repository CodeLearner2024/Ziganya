package com.codeLearner.Ziganya.models.report;

import com.codeLearner.Ziganya.models.contribution.ContributionRepository;
import com.codeLearner.Ziganya.models.credit.CreditRepository;
import com.codeLearner.Ziganya.models.member.Member;
import com.codeLearner.Ziganya.models.member.MemberConverter;
import com.codeLearner.Ziganya.models.member.MemberRepository;
import com.codeLearner.Ziganya.models.refund.RefundRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ReportService {

    private final ContributionRepository contributionRepository;
    private final CreditRepository creditRepository;
    private final RefundRepository refundRepository;
    private final MemberRepository memberRepository;
    private final MemberConverter converter;

    public ReportService(ContributionRepository contributionRepository, CreditRepository creditRepository, RefundRepository refundRepository, MemberRepository memberRepository, MemberConverter converter) {
        this.contributionRepository = contributionRepository;
        this.creditRepository = creditRepository;
        this.refundRepository = refundRepository;
        this.memberRepository = memberRepository;
        this.converter = converter;
    }

    public List<ReportResponse> getReport() {
        List<Member> members = memberRepository.findAll();

        List<ReportResponse> reports = new ArrayList<>();

        for (Member member:members){
            ReportResponse report = new ReportResponse();
            report.setMemberResponse(converter.convertToResponse(member));
            report.setActions(member.getManyOfActions());
            reports.add(report);

        }

        return reports;
    }
}
