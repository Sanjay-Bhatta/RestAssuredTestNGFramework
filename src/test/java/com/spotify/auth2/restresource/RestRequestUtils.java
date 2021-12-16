package com.spotify.auth2.restresource;

import io.qameta.allure.Step;
import io.restassured.response.Response;

import java.util.Map;

import static com.spotify.auth2.endpoints.PlayListRoutesConstant.TOKEN;
import static com.spotify.auth2.specbuilder.SpecBuilder.*;
import static io.restassured.RestAssured.given;

public class RestRequestUtils {
    @Step("Spotify POST Request")
    public static Response post(String endPoint, String accessToken, Object payloadObject){
        return given()
                .spec(getRequestSpecification())
                .auth()
                .oauth2(accessToken)
                .body(payloadObject)
                .post(endPoint)
                .then()
                .spec(getResponseSpecification())
                .extract()
                .response();
    }
    @Step("Spotify Account POST Request")
    public static Response postAccount(Map<String, String> formParams){
        return given()
                .spec(getAccountRequestSpecification())
                .formParams(formParams)
                .when()
                .post(TOKEN)
                .then()
                .spec(getResponseSpecification())
                .extract()
                .response();
    }
    @Step("Spotify GET Request")
    public static Response get(String endPoint, String accessToken){
        return given()
                .spec(getRequestSpecification())
                .auth()
                .oauth2(accessToken)
                .get(endPoint)
                .then()
                .spec(getResponseSpecification())
                .extract()
                .response();
    }
    @Step("Spotify PUT Request")
    public static Response put(String endPoint, String accessToken, Object payloadObject ){
        return given()
                .spec(getRequestSpecification())
                .auth()
                .oauth2(accessToken)
                .body(payloadObject)
                .put(endPoint)
                .then()
                .spec(getResponseSpecification())
                .extract()
                .response();
    }
}
