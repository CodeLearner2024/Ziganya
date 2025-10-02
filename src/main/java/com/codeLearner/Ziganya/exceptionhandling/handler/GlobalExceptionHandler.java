package com.codeLearner.Ziganya.exceptionhandling.handler;

import com.codeLearner.Ziganya.i18n.LocalizationService;
import com.codeLearner.Ziganya.exceptionhandling.exception.ApiExceptionMessage;
import com.codeLearner.Ziganya.exceptionhandling.exception.UnsupportedOperationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;

@RestControllerAdvice
public class GlobalExceptionHandler {

    private final LocalizationService localizationService;

    @Autowired
    public GlobalExceptionHandler(LocalizationService localizationService) {
        this.localizationService = localizationService;
    }

    @ExceptionHandler(value = UnsupportedOperationException.class)
    public ResponseEntity<ApiExceptionMessage> handleUnsupportedOperationException(
            UnsupportedOperationException exception, WebRequest webRequest) {

        HttpStatus httpStatus = HttpStatus.NOT_FOUND;
        ApiExceptionMessage apiExceptionMessage = new ApiExceptionMessage(LocalDateTime.now(),
                this.localizationService.getLocalizedMessage(exception.getErrorMessageKey()),
                webRequest.getDescription(false),
                String.format(this.localizationService.getLocalizedMessage(exception.getDescriptionMessageKey()),
                        this.localizationService.getLocalizedMessage(exception.getInjectedMessageKey())),
                httpStatus);
        return new ResponseEntity<>(apiExceptionMessage, httpStatus);
    }
}
