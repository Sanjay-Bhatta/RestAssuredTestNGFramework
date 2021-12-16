package com.spotify.auth2.pojo.error;

public class ErrorRootPOJO extends ErrorBasePOJO{
    private ErrorPage error;

    public ErrorRootPOJO(ErrorPage error) {
        this.error = error;
    }

    public ErrorRootPOJO() {
    }

    public ErrorPage getError() {
        return error;
    }

    public ErrorRootPOJO setError(ErrorPage error) {
        this.error = error;
        return this;
    }
}
