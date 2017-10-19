package com.flowable.entity;

public class User {

    private String name;

    private String userName;

    private String group;

    public User(String name, String userName, String group) {
        this.name = name;
        this.userName = userName;
        this.group = group;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }
}
