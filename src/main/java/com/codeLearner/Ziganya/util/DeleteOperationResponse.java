package com.codeLearner.Ziganya.util;

public class DeleteOperationResponse {

    private boolean deleted;

    public DeleteOperationResponse(boolean deleted) {
        this.deleted = deleted;
    }

    public static DeleteOperationResponse deleteCompletedSuccessfully() {
        return new DeleteOperationResponse(true);
    }

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }

}
