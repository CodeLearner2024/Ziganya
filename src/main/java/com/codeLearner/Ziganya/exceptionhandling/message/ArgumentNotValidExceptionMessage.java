/**
 *
 */
package com.codeLearner.Ziganya.exceptionhandling.message;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class ArgumentNotValidExceptionMessage {

    private String description;
    private String path;
    private Map<Object, List<ExceptionValueMessageStructure>> fieldsErrors = new HashMap<>();

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

    public Map<Object, List<ExceptionValueMessageStructure>> getFieldsErrors() {
        return fieldsErrors;
    }

    public void setFieldsErrors(Map<Object, List<ExceptionValueMessageStructure>> fieldsErrors) {
        this.fieldsErrors = fieldsErrors;
    }

}
