package com.nz.portfolio.model;

public class token {
    private int id;
    private String token;

    public token(int id, String token) {
        this.id = id;
        this.token = token;
    }

    public int getId() {
        return id;
    }

    public String getToken() {
        return token;
    }

    public void setId(int id) {
        this.id = id;
    }


    public void setToken(String token) {
        this.token = token;
    }
}
