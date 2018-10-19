
package com.miguelcr.a02_duckhunt;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class LoginResponse {

    @SerializedName("token")
    @Expose
    private String token;
    @SerializedName("username")
    @Expose
    private String username;
    @SerializedName("email")
    @Expose
    private String email;
    @SerializedName("ducks")
    @Expose
    private long ducks;

    /**
     * No args constructor for use in serialization
     * 
     */
    public LoginResponse() {
    }

    /**
     * 
     * @param username
     * @param email
     * @param token
     * @param ducks
     */
    public LoginResponse(String token, String username, String email, long ducks) {
        super();
        this.token = token;
        this.username = username;
        this.email = email;
        this.ducks = ducks;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public LoginResponse withToken(String token) {
        this.token = token;
        return this;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public LoginResponse withUsername(String username) {
        this.username = username;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LoginResponse withEmail(String email) {
        this.email = email;
        return this;
    }

    public long getDucks() {
        return ducks;
    }

    public void setDucks(long ducks) {
        this.ducks = ducks;
    }

    public LoginResponse withDucks(long ducks) {
        this.ducks = ducks;
        return this;
    }

}
