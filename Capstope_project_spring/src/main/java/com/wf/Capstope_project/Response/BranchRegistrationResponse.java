package com.wf.Capstope_project.Response;

public class BranchRegistrationResponse {
    private boolean status;
    private int statusCode;
    private String message;

    public BranchRegistrationResponse(){

    }

    public BranchRegistrationResponse(boolean status, int statusCode, String  message) {
        this.status = status;
        this.statusCode = statusCode;
        this.message = message;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
