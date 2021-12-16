package com.spotify.auth2.test;

import com.spotify.auth2.endpoints.PlayListRestAssuredUtils;
import com.spotify.auth2.pojo.error.ErrorPage;
import com.spotify.auth2.pojo.error.ErrorRootPOJO;
import com.spotify.auth2.pojo.playlist.crud.PlaylistItemPOJO;
import io.qameta.allure.Description;
import io.qameta.allure.Step;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PlayListTest {
    private static String playListID;
    @Step("PLayList Builder")
    public PlaylistItemPOJO playlistItemBuilder(String playListName, String playListDescription, boolean _public){
        return new PlaylistItemPOJO()
                .setName(playListName)
                .setDescription(playListDescription)
                .setPublic(_public);
    }
    @Step("Error Page Builder")
    public ErrorPage errorPageBuilder(int status, String message){
        return new ErrorPage()
                .setStatus(status)
                .setMessage(message);
    }
    @Step("Asserting PlayList Response")
    public void assertPlayListValues(PlaylistItemPOJO requestPlaylist, PlaylistItemPOJO responsePlaylist){
        Assert.assertEquals(requestPlaylist.getName(), responsePlaylist.getName(),
                "Playlist Name Matched");
        Assert.assertEquals(requestPlaylist.getDescription(), responsePlaylist.getDescription(),
                "PlayList Description Matched");
        Assert.assertEquals(requestPlaylist.isPublic(), responsePlaylist.isPublic(),
                "PlayList Public Value Matched");
    }
    @Step("Asserting Status Code")
    public void assertStatusCode(int expected, int actual){
        Assert.assertEquals(expected, actual, "Status Code Matched");
    }
    @Step("Asserting Error Response")
    public void assertErrorResponse(ErrorPage requestObj, ErrorRootPOJO responseObj){
        Assert.assertEquals(requestObj.getMessage(), responseObj.getError().getMessage(),
                "Error Description Matched");
        Assert.assertEquals(requestObj.getStatus(), responseObj.getError().getStatus(),
                "Error Response Status Matched");
    }
    @Test(priority = 1)
    @Description("Test Create PlayList")
    public void testCreatePlayList(){
        PlaylistItemPOJO requestPlaylist = playlistItemBuilder("POJO Name",
                "POJO Description", false);
        Response httpResponse = PlayListRestAssuredUtils.post(requestPlaylist);
        assertStatusCode(HttpStatus.SC_CREATED, httpResponse.statusCode());
        PlaylistItemPOJO responsePlaylist = httpResponse.as(PlaylistItemPOJO.class);
        assertPlayListValues(requestPlaylist, responsePlaylist);
        playListID = responsePlaylist.getId();
    }

    @Test(priority = 2)
    @Description("Test Get Playlist")
    public void testGetPlayList(){
        PlaylistItemPOJO requestPlaylist = playlistItemBuilder("POJO Name",
                "POJO Description", false);
        Response httpResponse = PlayListRestAssuredUtils.get(playListID);
        assertStatusCode(HttpStatus.SC_OK, httpResponse.statusCode());
        PlaylistItemPOJO responsePlayList = httpResponse.as(PlaylistItemPOJO.class);
        assertPlayListValues(requestPlaylist, responsePlayList);
    }

    @Test(priority = 3)
    @Description("Test Update PlayList")
    public void testUpdatePlayList(){
        PlaylistItemPOJO requestPlaylist = playlistItemBuilder("Updated POJO Name",
                "Updated POJO Description", true);
        Response httpResponse = PlayListRestAssuredUtils.put(requestPlaylist, playListID);
        assertStatusCode(HttpStatus.SC_OK, httpResponse.statusCode());
    }

    @Test(priority = 4)
    @Description("Test Fetch Updated PlayList")
    public void testFetchUpdatedPlayList(){
        PlaylistItemPOJO requestPlaylist = playlistItemBuilder("Updated POJO Name",
                "Updated POJO Description", true);
        Response httpResponse = PlayListRestAssuredUtils.get(playListID);
        assertStatusCode(HttpStatus.SC_OK, httpResponse.statusCode());
        PlaylistItemPOJO responsePlayList = httpResponse.as(PlaylistItemPOJO.class);
        assertPlayListValues(requestPlaylist, responsePlayList);
    }

    @Test(priority = 5)
    @Description("Test Negative Scenarios for Create PlayList")
    public void testNegativeCreatePlayList(){
        PlaylistItemPOJO requestPlaylist = playlistItemBuilder("",
                "POJO Negative Description", false);
        ErrorPage errorRequest = errorPageBuilder(HttpStatus.SC_BAD_REQUEST, "Missing required field: name");
        Response httpResponse = PlayListRestAssuredUtils.post(requestPlaylist);
        assertStatusCode(HttpStatus.SC_BAD_REQUEST, httpResponse.statusCode());
        ErrorRootPOJO errorResponse = httpResponse.as(ErrorRootPOJO.class);
        assertErrorResponse(errorRequest, errorResponse);
    }

    @Test(priority = 6)
    @Description("Test Create PlayList With Invalid Token")
    public void testCreatePlayListInvalidToken(){
        String invalidToken = "12345";
        PlaylistItemPOJO requestPlaylist = playlistItemBuilder("POJO Name",
                "POJO Description", false);
        ErrorPage errorRequest = errorPageBuilder(HttpStatus.SC_UNAUTHORIZED, "Invalid access token");
        Response httpResponse = PlayListRestAssuredUtils.post(requestPlaylist, invalidToken);
        assertStatusCode(HttpStatus.SC_UNAUTHORIZED, httpResponse.statusCode());
        ErrorRootPOJO errorResponse = httpResponse.as(ErrorRootPOJO.class);
        assertErrorResponse(errorRequest, errorResponse);

    }
}
