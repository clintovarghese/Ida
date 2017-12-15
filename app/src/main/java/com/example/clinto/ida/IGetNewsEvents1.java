package com.example.clinto.ida;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by Clinto on 26-Sep-17.
 */

public interface IGetNewsEvents1 {
    @GET("api/news/list/")
    Call<ArrayList<News>> getNews();
}
