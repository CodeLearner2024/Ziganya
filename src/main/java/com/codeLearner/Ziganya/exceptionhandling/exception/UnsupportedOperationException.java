package com.codeLearner.Ziganya.exceptionhandling.exception;


public class UnsupportedOperationException extends RuntimeException implements MessageKeyError {

    private final String errorMessageKey;
    private final String descriptionMessageKey;
    private final String injectedMessageKey;

    public UnsupportedOperationException(String errorMessageKey, String injectedMessageKey, String descriptionMessageKey) {
        this.injectedMessageKey = injectedMessageKey;
        this.errorMessageKey = errorMessageKey;
        this.descriptionMessageKey = descriptionMessageKey;
    }

    @Override
    public String getErrorMessageKey() {
        return errorMessageKey;
    }

    @Override
    public String getDescriptionMessageKey() {
        return descriptionMessageKey;
    }

    public String getInjectedMessageKey() {
        return injectedMessageKey;
    }


}
