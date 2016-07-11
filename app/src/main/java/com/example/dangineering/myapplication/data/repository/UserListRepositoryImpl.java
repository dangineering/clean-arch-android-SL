package com.example.dangineering.myapplication.data.repository;

import android.content.Context;

import com.example.dangineering.myapplication.data.model.UserModel;
import com.example.dangineering.myapplication.network.SlackAPIRepository;
import com.example.dangineering.myapplication.storage.InternalCache;

import java.util.List;

public class UserListRepositoryImpl implements UserListRepository {

    // create the cache and network
    SlackAPIRepository slackAPIRepository;

    InternalCache internalCache;

    Context context;

    public UserListRepositoryImpl(Context context) {
        this.context = context;
        // init cache
        internalCache = new InternalCache(context);

        // init network
        slackAPIRepository = new SlackAPIRepository();
    }


    @Override
    public List<UserModel> getUserList(boolean refresh) {
        if (refresh) {
            List<UserModel> fromNetwork = slackAPIRepository.getUserList();
            internalCache.write(fromNetwork);
            return fromNetwork;
        } else {

            List<UserModel> fromCache = internalCache.getCached();

            if (!fromCache.isEmpty()) {
                return fromCache;
            } else {
                //this is blocking call;
                List<UserModel> fromNetwork = slackAPIRepository.getUserList();
                internalCache.write(fromNetwork);
                return fromNetwork;
            }

        }
    }
}
