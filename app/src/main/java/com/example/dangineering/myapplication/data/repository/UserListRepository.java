package com.example.dangineering.myapplication.data.repository;

import com.example.dangineering.myapplication.data.model.UserModel;

import java.util.List;

public interface UserListRepository {

    List<UserModel> getUserList(boolean refresh);

}
