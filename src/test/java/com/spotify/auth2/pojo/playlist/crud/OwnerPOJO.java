package com.spotify.auth2.pojo.playlist.crud;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class OwnerPOJO {
    private String display_name;
    private ExternalURLs external_urls;
    private String href;
    private String id;
    private String type;
    private String uri;

    public OwnerPOJO(String display_name, ExternalURLs external_urls, String href, String id, String type, String uri) {
        this.display_name = display_name;
        this.external_urls = external_urls;
        this.href = href;
        this.id = id;
        this.type = type;
        this.uri = uri;
    }

    public OwnerPOJO() {
    }

    public String getDisplay_name() {
        return display_name;
    }

    public void setDisplay_name(String display_name) {
        this.display_name = display_name;
    }

    public ExternalURLs getExternal_urls() {
        return external_urls;
    }

    public void setExternal_urls(ExternalURLs external_urls) {
        this.external_urls = external_urls;
    }

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }
}
