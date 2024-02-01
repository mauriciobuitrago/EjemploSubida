package com.co.qvision.models.builders;

import com.co.qvision.models.Credentials;
import com.co.qvision.utils.Builder;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class DataBuilder implements Builder<Credentials> {

    private String username;
    private String password;

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    protected static Credentials ObjCredentials;

    private List<DataBuilder> listData= new ArrayList<>();

    private DataBuilder(Map<String, String> data) {
        this.username = data.get("username");
        this.password = data.get("password");
    }

    public static DataBuilder dataInformation(List<Map<String, String>> DataCredential) {
        return new DataBuilder(DataCredential);
    }

    public DataBuilder(List<Map<String, String>> dataCard) {
        createConstructor(dataCard);
    }


    private void createConstructor(List<Map<String, String>> dataCard) {
        for (Map<String, String> data : dataCard) {
            listData.add(new DataBuilder(data));
        }
    }

    public static void setPersona(Credentials credentials) {
        DataBuilder.ObjCredentials = credentials;
    }

    @Override
    public Credentials build() {
        Credentials createdCredential = new Credentials(this);
        DataBuilder.setPersona(createdCredential);
        return createdCredential;
    }

    public List<DataBuilder> getListData() {
        return listData;
    }
}
