package com.example.dangineering.myapplication.presentation.viewmodel;

public class UserListViewModel {

    private String userName;

    private String profileUrl;

    public UserListViewModel(String userName, String profileUrl) {
        this.userName = userName;
        this.profileUrl = profileUrl;
    }

    public String getProfileUrl() {
        return profileUrl;
    }

    public void setProfileUrl(String profileUrl) {
        this.profileUrl = profileUrl;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
