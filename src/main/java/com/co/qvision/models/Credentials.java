package com.co.qvision.models;

import com.co.qvision.models.builders.DataBuilder;

public class Credentials {

    private String username;
    private String password;

    public Credentials(DataBuilder dataBuilder) {
        this.username = dataBuilder.getListData().get(0).getUsername();
        this.password = dataBuilder.getListData().get(0).getPassword();
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

}
