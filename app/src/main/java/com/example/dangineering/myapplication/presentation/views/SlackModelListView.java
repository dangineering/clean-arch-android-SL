package com.example.dangineering.myapplication.presentation.views;

import com.example.dangineering.myapplication.presentation.viewmodel.UserListViewModel;

import java.util.List;

public interface SlackModelListView extends View {

    void add(List<UserListViewModel> userViewModelList);

}
