

package com.hanzo.github.http.model;

import com.google.gson.annotations.SerializedName;
import com.hanzo.github.AppConfig;
import com.hanzo.github.BuildConfig;

import java.util.Arrays;
import java.util.List;

/**
 * Created on 2017/8/1.
 *
 * @author ThirtyDegreesRay
 */

public class AuthRequestModel {

    private List<String> scopes;
    private String note;
    private String noteUrl;
    @SerializedName("client_id") private String clientId;
    @SerializedName("client_secret") private String clientSecret;

    public static AuthRequestModel generate(){
        AuthRequestModel model = new AuthRequestModel();
        model.scopes = Arrays.asList("user", "repo", "gist", "notifications");
        model.note = BuildConfig.APPLICATION_ID;
        model.clientId = AppConfig.GITHUB_CLIENT_ID;
        model.clientSecret = AppConfig.GITHUB_CLIENT_SECRET;
        model.noteUrl = AppConfig.REDIRECT_URL;
        return model;
    }

    public List<String> getScopes() {
        return scopes;
    }

    public String getNote() {
        return note;
    }

    public String getNoteUrl() {
        return noteUrl;
    }

    public String getClientId() {
        return clientId;
    }

    public String getClientSecret() {
        return clientSecret;
    }
}
