package com.example.clinto.ida;

import android.app.Application;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Clinto on 26-Sep-17.
 */

public class MyApplication extends Application {
    public static final String BASE_URL = "http://iroidtech.com/ida/api/";
    private static Retrofit retrofit = null;

    @Override
    public void onCreate() {
        super.onCreate();

    }

    public static Retrofit getClient() {
        if (retrofit==null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(AppConstants.MAIN_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }
}