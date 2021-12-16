package com.spotify.auth2.tokenmanager;

import com.spotify.auth2.restresource.RestRequestUtils;
import com.spotify.auth2.utils.ConfigLoader;
import io.restassured.response.Response;
import org.apache.commons.lang3.StringUtils;

import java.time.Instant;
import java.util.HashMap;
import java.util.Map;

public class TokenManager {
    private static String access_token;
    private static Instant expiry_time;

    public synchronized static String getToken(){
        try{
            if (StringUtils.isBlank(access_token) || Instant.now().isAfter(expiry_time)){
                Response response = renewToken();
                access_token = response.path("access_token");
                int expiry_duration_in_seconds = response.path("expires_in");
                expiry_time = Instant.now().plusSeconds(expiry_duration_in_seconds - 300);
            }
        }
        catch(Exception e){
                throw new RuntimeException("Aborting test execution as renew token failed");
        }
        return access_token;
    }
    private static Response renewToken(){
        Map<String, String> formParams = new HashMap<String, String>();
        formParams.put("client_id", ConfigLoader.getInstance().getClientId());
        formParams.put("client_secret", ConfigLoader.getInstance().getClientSecret());
        formParams.put("refresh_token", ConfigLoader.getInstance().getRefreshToken());
        formParams.put("grant_type", ConfigLoader.getInstance().getGrantType());
        Response response = RestRequestUtils.postAccount(formParams);
        if(response.statusCode()!=200){
            throw new RuntimeException("Test aborted as token generation failed");
        }
        else{
            return response;
        }

    }
}
