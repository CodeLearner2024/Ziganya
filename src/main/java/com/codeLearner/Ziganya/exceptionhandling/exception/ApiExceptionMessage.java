package com.codeLearner.Ziganya.exceptionhandling.exception;

import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;


public class ApiExceptionMessage {

    /**
     * The time when an exception is thrown
     */
    private LocalDateTime time;
    /**
     * The short message why the exception occurred
     */
    private String errorMessage;
    /**
     * The path is the request uri
     */
    private String path;
    /**
     * The description is the detailed message about the exception
     */
    private String description;
    private HttpStatus httpStatus;

    public ApiExceptionMessage(LocalDateTime time, String errorMessage, String path, String description, HttpStatus httpStatus) {
        this.time = time;
        this.errorMessage = errorMessage;
        this.path = path;
        this.description = description;
        this.httpStatus = httpStatus;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    public void setHttpStatus(HttpStatus httpStatus) {
        this.httpStatus = httpStatus;
    }
}
