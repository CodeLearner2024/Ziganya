package com.codeLearner.Ziganya.models.dashboard;

import com.codeLearner.Ziganya.exceptionhandling.exception.UnsupportedOperationException;
import com.codeLearner.Ziganya.i18n.I18nConstants;
import com.codeLearner.Ziganya.i18n.I18nConstantsInjectedMessages;
import com.codeLearner.Ziganya.models.associationaccount.AssociationAccount;
import com.codeLearner.Ziganya.models.associationaccount.AssociationAccountRepository;
import com.codeLearner.Ziganya.models.member.Member;
import com.codeLearner.Ziganya.models.member.MemberRepository;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

@Service
public class ReportingService {

    private final MemberRepository memberRepository;
    private final AssociationAccountRepository associationAccountRepository;
    private final SimpMessagingTemplate messagingTemplate;

    public ReportingService(MemberRepository memberRepository,
                            AssociationAccountRepository associationAccountRepository,
                            SimpMessagingTemplate messagingTemplate) {
        this.memberRepository = memberRepository;
        this.associationAccountRepository = associationAccountRepository;
        this.messagingTemplate = messagingTemplate;
    }

    public ReportingResponse getReporting() {
        AssociationAccount associationAccount = associationAccountRepository.findCurrentAssociationAccount();
        if (associationAccount == null) {
            throw new UnsupportedOperationException(
                    I18nConstantsInjectedMessages.NO_ASSOCIATION_ACCOUNT_FOUND_KEY,
                    I18nConstants.NO_ASSOCIATION_ACCOUNT_FOUND,
                    I18nConstants.NO_ASSOCIATION_ACCOUNT_FOUND
            );
        }

        ReportingResponse response = new ReportingResponse();
        response.setTotalMembers(memberRepository.findAll().size());
        response.setTotalActions(memberRepository.findAll().stream().mapToInt(Member::getManyOfActions).sum());
        response.setTotalCurrentBalance(associationAccount.getCurrentAmount());
        response.setTotalLoanBalance(associationAccount.getLoanBalance());
        return response;
    }

    public void notifyDashboardUpdate() {
        ReportingResponse updatedData = getReporting();
        messagingTemplate.convertAndSend("/topic/dashboard", updatedData);
    }
}
