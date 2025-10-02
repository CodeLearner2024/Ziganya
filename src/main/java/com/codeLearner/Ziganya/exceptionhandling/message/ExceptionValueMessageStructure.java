
package com.codeLearner.Ziganya.exceptionhandling.message;

public class ExceptionValueMessageStructure {

    private Object field;
    private Object message;
    private Object rejectedValue;

    public ExceptionValueMessageStructure(Object field, Object message, Object rejectedValue) {
        this.field = field;
        this.message = message;
        this.rejectedValue = rejectedValue;
    }

    public Object getField() {
        return field;
    }

    public void setField(Object field) {
        this.field = field;
    }

    public Object getMessage() {
        return message;
    }

    public void setMessage(Object message) {
        this.message = message;
    }

    public Object getRejectedValue() {
        return rejectedValue;
    }

    public void setRejectedValue(Object rejectedValue) {
        this.rejectedValue = rejectedValue;
    }

}
