package com.example.dangineering.myapplication.presentation.presenter.impl;

import com.example.dangineering.myapplication.data.model.UserModel;
import com.example.dangineering.myapplication.data.repository.UserListRepository;
import com.example.dangineering.myapplication.data.repository.UserListRepositoryImpl;
import com.example.dangineering.myapplication.domain.interactor.GetSlackUsers;
import com.example.dangineering.myapplication.domain.interactor.impl.GetSlackUsersImpl;
import com.example.dangineering.myapplication.executors.InteractorExecutor;
import com.example.dangineering.myapplication.executors.MainThreadExecutor;
import com.example.dangineering.myapplication.executors.impl.InteractorExecutorImpl;
import com.example.dangineering.myapplication.executors.impl.MainThreadExecutorImpl;
import com.example.dangineering.myapplication.presentation.presenter.SlackPresenter;
import com.example.dangineering.myapplication.presentation.viewmodel.UserListViewModel;
import com.example.dangineering.myapplication.presentation.views.SlackModelListView;

import java.util.ArrayList;
import java.util.List;

public class SlackPresenterImpl implements SlackPresenter {

    // has instance of interactor
    GetSlackUsers getSlackUsers;

    SlackModelListView slackModelListView;

    @Override
    public void initialize() {
        getSlackUsers(true);
    }

    private void getSlackUsers(boolean refresh) {

        MainThreadExecutor mainThreadExecutor = new MainThreadExecutorImpl();

        InteractorExecutor interactorExecutor = new InteractorExecutorImpl();

        UserListRepository userListRepository = new UserListRepositoryImpl(getView().getContext());

        getSlackUsers = new GetSlackUsersImpl(interactorExecutor, mainThreadExecutor, userListRepository);

        getSlackUsers.execute(refresh, new GetSlackUsers.Callback() {
            @Override
            public void onResult(List<UserModel> userModelList) {
                getView().add(convertToViewModel(userModelList));
            }

            @Override
            public void onError() {

            }
        });
    }

    private List<UserListViewModel> convertToViewModel(List<UserModel> userModelList) {

        List<UserListViewModel> userListViewModels = new ArrayList<>();

        for (UserModel userModel : userModelList) {
            userListViewModels.add(new UserListViewModel(userModel.getRealName(), userModel.getImageUrl()));
        }
        return userListViewModels;
    }

    @Override
    public void onViewCreate() {

    }

    @Override
    public void onViewResume() {
        
    }

    @Override
    public void onViewDestroy() {

    }

    @Override
    public void setView(SlackModelListView view) {
        slackModelListView = view;
    }

    @Override
    public SlackModelListView getView() {
        return slackModelListView;
    }
}
