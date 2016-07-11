package com.example.dangineering.myapplication.presentation.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.dangineering.myapplication.R;
import com.example.dangineering.myapplication.presentation.recyclerview.SlackListViewHolder;
import com.example.dangineering.myapplication.presentation.viewmodel.UserListViewModel;

import java.util.ArrayList;
import java.util.List;

public class SlackModelAdapter extends RecyclerView.Adapter<SlackListViewHolder> {

    private List<UserListViewModel> UserListViewModels;

    public SlackModelAdapter() {
        UserListViewModels = new ArrayList<>();
    }

    public void setData(List<UserListViewModel> UserListViewModels) {
        this.UserListViewModels.clear();
        this.UserListViewModels.addAll(UserListViewModels);
        notifyDataSetChanged();
    }


    @Override
    public SlackListViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // inflate and return view holder

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.image_item_view, parent, false);  // it will crash without this!
        return new SlackListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(SlackListViewHolder holder, int position) {

        UserListViewModel curUserListViewModel = UserListViewModels.get(position);

        holder.setImageUri(curUserListViewModel.getProfileUrl());
        holder.setTextView(curUserListViewModel.getUserName());

    }

    @Override
    public int getItemCount() {
        return UserListViewModels.size();
    }
}
