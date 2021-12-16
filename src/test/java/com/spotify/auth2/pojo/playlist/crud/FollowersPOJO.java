package com.spotify.auth2.pojo.playlist.crud;

public class FollowersPOJO {
    private String href;
    private int total;

    public FollowersPOJO(String href, int total) {
        this.href = href;
        this.total = total;
    }

    public FollowersPOJO() {
    }

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }
}
