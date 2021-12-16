package com.spotify.auth2.pojo.playlist.crud;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class ExternalURLs {
    private String spotify;

    public ExternalURLs(String spotify) {
        this.spotify = spotify;
    }

    public ExternalURLs() {
    }

    public String getSpotify() {
        return spotify;
    }

    public void setSpotify(String spotify) {
        this.spotify = spotify;
    }
}
