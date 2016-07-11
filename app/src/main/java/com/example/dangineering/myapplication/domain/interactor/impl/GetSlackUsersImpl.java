package com.example.dangineering.myapplication.domain.interactor.impl;

import com.example.dangineering.myapplication.data.model.UserModel;
import com.example.dangineering.myapplication.data.repository.UserListRepository;
import com.example.dangineering.myapplication.domain.interactor.GetSlackUsers;
import com.example.dangineering.myapplication.executors.InteractorExecutor;
import com.example.dangineering.myapplication.executors.MainThreadExecutor;

import java.util.List;

public class GetSlackUsersImpl extends AbstractInteractor implements GetSlackUsers {

    // interactor has dependency of Repository impl
    UserListRepository userListRepository;

    // any arguments
    boolean refresh;

    // and callback
    Callback callback;

    public GetSlackUsersImpl(InteractorExecutor interactorExecutor, MainThreadExecutor mainThreadExecutor, UserListRepository userListRepository) {
        super(interactorExecutor, mainThreadExecutor);
        this.userListRepository = userListRepository;
    }

    // interface from get slack users
    @Override
    public void execute(boolean refresh, Callback callback) {
        this.refresh = refresh;
        this.callback = callback;

        getInteractorExecutor().run(this);
    }


    // this method is mainly for retrieving from repository and posting to the UI Thread
    @Override
    public void run() {

        // get the result

        final List<UserModel> userModels = userListRepository.getUserList(refresh);

        getMainThreadExecutor().execute(new Runnable() {
            @Override
            public void run() {
                callback.onResult(userModels);
            }
        });

    }
}
