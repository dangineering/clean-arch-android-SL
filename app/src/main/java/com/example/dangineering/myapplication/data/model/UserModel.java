package com.example.dangineering.myapplication.data.model;

import java.io.Serializable;

public class UserModel implements Serializable {

    private String imageUrl;

    private String userName;

    private String realName;

    private String jobTitle;

    public UserModel(String imageUrl, String userName, String jobTitle, String realName) {
        this.imageUrl = imageUrl;
        this.userName = userName;
        this.jobTitle = jobTitle;
        this.realName = realName;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }
}
