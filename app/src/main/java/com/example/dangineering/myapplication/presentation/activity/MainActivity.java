package com.example.dangineering.myapplication.presentation.activity;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.dangineering.myapplication.R;
import com.example.dangineering.myapplication.presentation.adapter.ModelAdapter;
import com.example.dangineering.myapplication.presentation.adapter.SlackModelAdapter;
import com.example.dangineering.myapplication.presentation.presenter.GettyPresenter;
import com.example.dangineering.myapplication.presentation.presenter.SlackPresenter;
import com.example.dangineering.myapplication.presentation.presenter.impl.SlackPresenterImpl;
import com.example.dangineering.myapplication.presentation.viewmodel.ImageViewModel;
import com.example.dangineering.myapplication.presentation.viewmodel.UserListViewModel;
import com.example.dangineering.myapplication.presentation.views.ModelListView;
import com.example.dangineering.myapplication.presentation.views.SlackModelListView;


import java.util.List;

public class MainActivity extends AppCompatActivity implements SlackModelListView {


    RecyclerView recyclerView;
    SlackModelAdapter slackModelAdapter;

    // view holds the presenter
    SlackPresenter slackPresenter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initModelListAdapter();

        initPresenter();


    }

    private void initPresenter() {
        slackPresenter = new SlackPresenterImpl();
        slackPresenter.setView(this);
        slackPresenter.initialize();
    }

    private void initModelListAdapter() {

        recyclerView = (RecyclerView) findViewById(R.id.recycler);
        slackModelAdapter = new SlackModelAdapter();

        // use good old linear layout manager
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));

        recyclerView.setAdapter(slackModelAdapter);

        // no need for default animator
    }



    @Override
    public void add(List<UserListViewModel> userViewModelList) {
        slackModelAdapter.setData(userViewModelList);
    }


    @Override
    public Context getContext() {
        return this;
    }
}
