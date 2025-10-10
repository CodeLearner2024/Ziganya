package com.codeLearner.Ziganya.models.associationaccount;

import com.codeLearner.Ziganya.exceptionhandling.exception.UnsupportedOperationException;
import com.codeLearner.Ziganya.i18n.I18nConstants;
import com.codeLearner.Ziganya.i18n.I18nConstantsInjectedMessages;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class AssociationAccountServiceImpl implements AssociationAccountService{
    private final AssociationAccountRepository associationAccountRepository;
    private final AssociationAccountConverter associationAccountConverter;

    public AssociationAccountServiceImpl(AssociationAccountRepository associationAccountRepository, AssociationAccountConverter associationAccountConverter) {
        this.associationAccountRepository = associationAccountRepository;
        this.associationAccountConverter = associationAccountConverter;
    }

    @Override
    public AssociationAccountResponse createAssociationAccount(AssociationAccountRequest request) {
        AssociationAccount associationAccount = associationAccountConverter.convertToEntity(request);
        AssociationAccount savedAssociationAccount = associationAccountRepository.save(associationAccount);
        return associationAccountConverter.convertToResponse(savedAssociationAccount);
    }

    @Override
    public List<AssociationAccountResponse> getAllAssociationAccounts() {
        return this.associationAccountRepository.findAll().stream().map(associationAccountConverter::convertToResponse).toList();
    }

    @Override
    public AssociationAccountResponse getAssociationAccountByPeriod(LocalDate cycleStartDate, LocalDate cycleEndDate) {
        return this.associationAccountRepository.getAssociationAccountByPeriod(cycleStartDate, cycleEndDate).map(associationAccountConverter::convertToResponse).orElseThrow(() -> new UnsupportedOperationException(I18nConstantsInjectedMessages.NO_ASSOCIATION_ACCOUNT_FOUND_KEY, I18nConstants.NO_ASSOCIATION_ACCOUNT_FOUND,I18nConstants.NO_ASSOCIATION_ACCOUNT_FOUND));
    }

    @Override
    public AssociationAccountResponse getCurrentAssociationAccount() {
        return associationAccountConverter.convertToResponse(associationAccountRepository.findCurrentAssociationAccount());
    }
}
