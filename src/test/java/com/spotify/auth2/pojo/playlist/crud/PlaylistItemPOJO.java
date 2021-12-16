package com.spotify.auth2.pojo.playlist.crud;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PlaylistItemPOJO {
    @JsonInclude(JsonInclude.Include.NON_DEFAULT)
    private boolean collaborative;
    private String description;
    private ExternalURLs external_urls;
    private FollowersPOJO followers;
    private String href;
    private String id;
    private List<Object> images;
    private String name;
    private OwnerPOJO owner;
    private String primary_color;
    @JsonProperty("public")
    private boolean isPublic;
    private String snapshot_id;
    private Tracks tracks;
    private String type;
    private String uri;

    public PlaylistItemPOJO(boolean collaborative, String description, ExternalURLs external_urls, FollowersPOJO followers, String href, String id, List<Object> images, String name, OwnerPOJO owner, String primary_color, boolean isPublic, String snapshot_id, Tracks tracks, String type, String uri) {
        this.collaborative = collaborative;
        this.description = description;
        this.external_urls = external_urls;
        this.href = href;
        this.id = id;
        this.images = images;
        this.name = name;
        this.owner = owner;
        this.primary_color = primary_color;
        this.isPublic = isPublic;
        this.snapshot_id = snapshot_id;
        this.tracks = tracks;
        this.type = type;
        this.uri = uri;
    }

    public PlaylistItemPOJO() {
    }

    public boolean isCollaborative() {
        return collaborative;
    }

    public void setCollaborative(boolean collaborative) {
        this.collaborative = collaborative;
    }

    public String getDescription() {
        return description;
    }

    public PlaylistItemPOJO setDescription(String description) {
        this.description = description;
        return this;
    }

    public ExternalURLs getExternal_urls() {
        return external_urls;
    }

    public void setExternal_urls(ExternalURLs external_urls) {
        this.external_urls = external_urls;
    }

    public FollowersPOJO getFollowers() {
        return followers;
    }

    public void setFollowers(FollowersPOJO followers) {
        this.followers = followers;
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

    public List<Object> getImages() {
        return images;
    }

    public void setImages(List<Object> images) {
        this.images = images;
    }

    public String getName() {
        return name;
    }

    public PlaylistItemPOJO setName(String name) {
        this.name = name;
        return this;
    }

    public OwnerPOJO getOwner() {
        return owner;
    }

    public void setOwner(OwnerPOJO owner) {
        this.owner = owner;
    }

    public String getPrimary_color() {
        return primary_color;
    }

    public void setPrimary_color(String primary_color) {
        this.primary_color = primary_color;
    }

    public boolean isPublic() {
        return isPublic;
    }

    public PlaylistItemPOJO setPublic(boolean aPublic) {
        isPublic = aPublic;
        return this;
    }

    public String getSnapshot_id() {
        return snapshot_id;
    }

    public void setSnapshot_id(String snapshot_id) {
        this.snapshot_id = snapshot_id;
    }

    public Tracks getTracks() {
        return tracks;
    }

    public void setTracks(Tracks tracks) {
        this.tracks = tracks;
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
