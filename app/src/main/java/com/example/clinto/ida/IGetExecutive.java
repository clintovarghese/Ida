package com.example.clinto.ida;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by Clinto on 26-Sep-17.
 */

public interface IGetExecutive {
    @GET("api/users/details/type/1/")
    Call<ArrayList<Newsx>> getNewsx();
}
