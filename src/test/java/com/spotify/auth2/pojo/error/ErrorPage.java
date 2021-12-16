package com.spotify.auth2.pojo.error;

public class ErrorPage {
    private int status;
    private String message;

    public ErrorPage(int status, String message) {
        this.status = status;
        this.message = message;
    }

    public ErrorPage() {
    }

    public int getStatus() {
        return status;
    }

    public ErrorPage setStatus(int status) {
        this.status = status;
        return this;
    }

    public String getMessage() {
        return message;
    }

    public ErrorPage setMessage(String message) {
        this.message = message;
        return this;
    }
}
