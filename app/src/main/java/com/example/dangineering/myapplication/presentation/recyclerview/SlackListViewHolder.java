package com.example.dangineering.myapplication.presentation.recyclerview;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.dangineering.myapplication.R;
import com.squareup.picasso.Picasso;

public class SlackListViewHolder extends RecyclerView.ViewHolder {


    ImageView imageView;

    TextView textView;

    // this context
    Context context;

    /** constructor must bind views **/
    public SlackListViewHolder(View itemView) {

        super(itemView);
        this.imageView = (ImageView) itemView.findViewById(R.id.image_view);
        this.textView = (TextView) itemView.findViewById(R.id.text_view);
        this.context = itemView.getContext();
    }


    public void setImageUri(String uri){

        Picasso.with(context)
                .load(uri)
                .into(imageView);


    }

    public void setTextView(String text) {
        textView.setText(text);
    }
}
