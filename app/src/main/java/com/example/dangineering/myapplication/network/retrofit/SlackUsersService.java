package com.example.dangineering.myapplication.network.retrofit;

import com.example.dangineering.myapplication.network.responsemodel.UserListResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface SlackUsersService {

    @GET("users.list")
    Call<UserListResponse> getUserList(@Query("token") String token);

}
