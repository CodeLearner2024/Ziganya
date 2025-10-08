package com.codeLearner.Ziganya.exceptionhandling.handler;

import com.codeLearner.Ziganya.exceptionhandling.message.ArgumentNotValidExceptionMessage;
import com.codeLearner.Ziganya.exceptionhandling.message.ExceptionValueMessageStructure;
import com.codeLearner.Ziganya.i18n.LocalizationService;
import com.codeLearner.Ziganya.exceptionhandling.exception.ApiExceptionMessage;
import com.codeLearner.Ziganya.exceptionhandling.exception.UnsupportedOperationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

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

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
                                                                  HttpHeaders headers, HttpStatusCode status, WebRequest request) {
        ArgumentNotValidExceptionMessage exceptionMessage = new ArgumentNotValidExceptionMessage();
        Map<Object, List<ExceptionValueMessageStructure>> fieldsErrors = new HashMap<>();

        List<ExceptionValueMessageStructure> errorDetails = new ArrayList<>();
        ex.getBindingResult().getFieldErrors().forEach((fieldError) -> {
            exceptionMessage.setDescription(fieldError.getDefaultMessage());
            exceptionMessage.setPath(request.getDescription(false));
            errorDetails.add(new ExceptionValueMessageStructure(fieldError.getField(), fieldError.getDefaultMessage(),
                    fieldError.getRejectedValue()));

        });
        fieldsErrors.put("details", errorDetails);
        exceptionMessage.setFieldsErrors(fieldsErrors);
        return new ResponseEntity<>(exceptionMessage, status);
    }

    @Override
    protected ResponseEntity<Object> handleHttpRequestMethodNotSupported(HttpRequestMethodNotSupportedException ex,
                                                                         HttpHeaders headers, HttpStatusCode status, WebRequest request) {
        HttpStatus httpStatus = HttpStatus.METHOD_NOT_ALLOWED;
        ApiExceptionMessage apiExceptionMessage = new ApiExceptionMessage(LocalDateTime.now(),
                "",
                request.getDescription(false), "Wrong request to the wrong path", httpStatus);
        return new ResponseEntity<>(apiExceptionMessage, httpStatus);
    }


}
