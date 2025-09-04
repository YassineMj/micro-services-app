package com.yassine.billingservice.models;

public class CustomerModel {
    private String id;
    private String name;
    private String username;

    public CustomerModel(String id, String default_nom, String default_email) {
        this.id=id;
        this.name=default_nom;
        this.username=default_email;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
