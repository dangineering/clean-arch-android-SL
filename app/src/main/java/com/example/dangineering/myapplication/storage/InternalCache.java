package com.example.dangineering.myapplication.storage;

import android.content.Context;

import com.example.dangineering.myapplication.data.model.UserModel;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class InternalCache {

    private Context context;

    public InternalCache(Context context) {
        this.context = context;
    }

    public void write(List<UserModel> userModels) {
        File file;

        ObjectOutputStream objectOutputStream;
        try {
            // file = File.createTempFile("MyCache", null, getCacheDir());
            file = new File(context.getCacheDir(), "MyCache");

            objectOutputStream = new ObjectOutputStream(new FileOutputStream(file));
            objectOutputStream.writeObject(userModels);
            objectOutputStream.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<UserModel> getCached() {

        File file;

        List<UserModel> userModels = new ArrayList<>();

        ObjectInputStream objectInputStream;
        try {
            // file = File.createTempFile("MyCache", null, getCacheDir());
            file = new File(context.getCacheDir(), "MyCache");
            objectInputStream = new ObjectInputStream(new FileInputStream(file));
            try {
                userModels.addAll((List<UserModel>) objectInputStream.readObject());

            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }


        } catch (IOException e) {
            e.printStackTrace();
        }
        return userModels;

    }
}
