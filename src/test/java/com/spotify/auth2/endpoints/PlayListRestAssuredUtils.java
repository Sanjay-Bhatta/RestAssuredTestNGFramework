package com.spotify.auth2.endpoints;

import com.spotify.auth2.pojo.playlist.crud.PlaylistItemPOJO;
import com.spotify.auth2.restresource.RestRequestUtils;
import com.spotify.auth2.tokenmanager.TokenManager;
import com.spotify.auth2.utils.ConfigLoader;
import io.restassured.response.Response;

import static com.spotify.auth2.endpoints.PlayListRoutesConstant.PLAYLIST;
import static com.spotify.auth2.endpoints.PlayListRoutesConstant.USERS;

public class PlayListRestAssuredUtils {

    public static Response post(PlaylistItemPOJO requestPlaylist){
        return RestRequestUtils.post(USERS +"/" + ConfigLoader.getInstance().getUserId() + PLAYLIST,
                TokenManager.getToken(), requestPlaylist);
    }

    public static Response post(PlaylistItemPOJO requestPlaylist, String invalidToken){
        return RestRequestUtils.post(USERS + "/" + ConfigLoader.getInstance().getUserId() + PLAYLIST,
                invalidToken, requestPlaylist);
    }

    public static Response get(String playlistID){
        return RestRequestUtils.get(PLAYLIST + "/" + playlistID, TokenManager.getToken());
    }

    public static Response put(PlaylistItemPOJO requestPlaylist, String playlistID ){
        return RestRequestUtils.put(PLAYLIST + "/" + playlistID, TokenManager.getToken(), requestPlaylist);
    }
}
