package com.codeLearner.Ziganya.i18n;

import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Service;

@Service
public class LocalizationService {
    private final MessageSource messageSource;

    public LocalizationService(MessageSource messageSource) {
        this.messageSource = messageSource;
    }

    public String getLocalizedMessage(String messageCode) {
        return this.messageSource.getMessage(messageCode, null, "could not find a proper localized message",
                LocaleContextHolder.getLocale());
    }
}
