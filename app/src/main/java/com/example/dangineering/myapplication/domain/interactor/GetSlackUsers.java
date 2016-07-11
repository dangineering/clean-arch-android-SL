package com.example.dangineering.myapplication.domain.interactor;

import com.example.dangineering.myapplication.data.model.UserModel;

import java.util.List;

public interface GetSlackUsers {

    void execute(boolean refresh, Callback callback);

    interface Callback{

        void onResult(List<UserModel> userModelList);

        void onError();
    }
}
