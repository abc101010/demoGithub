package com.example.demofastjson.data;

public class UserInfo {

    private String id = "";
    private String Name = "";
    private String gender = "";

    public UserInfo() {
    }

    public UserInfo(String id, String name, String gender) {
        this.id = id;
        Name = name;
        this.gender = gender;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}
