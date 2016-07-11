package com.example.dangineering.myapplication.network;

import com.example.dangineering.myapplication.data.model.UserModel;
import com.example.dangineering.myapplication.data.repository.UserListRepository;
import com.example.dangineering.myapplication.network.responsemodel.Member;
import com.example.dangineering.myapplication.network.responsemodel.UserListResponse;
import com.example.dangineering.myapplication.network.retrofit.LoggingInterceptor;
import com.example.dangineering.myapplication.network.retrofit.SlackUsersService;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/** this library uses networking to implement the repository pattern for slack.
 *  TODO: add the memory caching.
 */
public class SlackAPIRepository {

    // this api repository needs to contain the retrofit service object.
    //
    // TODO: fill me here
    private static final String API_TOKEN = "";
    private static final String BASE_URL = "https://slack.com/api/";

    SlackUsersService slackUsersService;



   public SlackAPIRepository() {

       initRetrofit();
   }


    private void initRetrofit() {

        OkHttpClient okhttp = new OkHttpClient().newBuilder()
                .addInterceptor(new LoggingInterceptor())
                .build();

        //gson
        Gson gson = new GsonBuilder()
                .setDateFormat("yyyy-MM-dd'T'HH:mm:ssZ")
                .create();


        // create retrofit object with intercepter
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(okhttp)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        // create service
        slackUsersService = retrofit.create(SlackUsersService.class);

    }


    public List<UserModel> getUserList() {
        Call<UserListResponse> userListResponseCall = slackUsersService.getUserList(API_TOKEN);
        List<UserModel> userModels = new ArrayList<>();
        try {
            retrofit2.Response<UserListResponse> userListResponse = userListResponseCall.execute();
            userModels.addAll(convertToDataModel(userListResponse.body()));

        } catch (IOException e) {
            e.printStackTrace();
        }
        return userModels;
    }

    private List<UserModel> convertToDataModel(UserListResponse userListResponse) {
        List<UserModel> userModels = new ArrayList<>();
        for (Member member : userListResponse.getMembers()) {
            userModels.add(new UserModel(member.getProfile().getImage192(), member.getName(), member.getProfile().getFirstName(), member.getRealName()));
        }
        return userModels;

    }
}
