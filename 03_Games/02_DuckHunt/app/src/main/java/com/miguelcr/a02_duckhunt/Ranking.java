
package com.miguelcr.a02_duckhunt;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Ranking {

    @SerializedName("ducks")
    @Expose
    private long ducks;
    @SerializedName("username")
    @Expose
    private String username;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Ranking() {
    }

    /**
     * 
     * @param username
     * @param ducks
     */
    public Ranking(long ducks, String username) {
        super();
        this.ducks = ducks;
        this.username = username;
    }

    public long getDucks() {
        return ducks;
    }

    public void setDucks(long ducks) {
        this.ducks = ducks;
    }

    public Ranking withDucks(long ducks) {
        this.ducks = ducks;
        return this;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Ranking withUsername(String username) {
        this.username = username;
        return this;
    }

}
