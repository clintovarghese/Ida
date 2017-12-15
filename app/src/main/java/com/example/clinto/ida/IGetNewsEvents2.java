package com.example.clinto.ida;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by Clinto on 27-Sep-17.
 */

public interface IGetNewsEvents2 {
    @GET("api/unit_details/unitdetails_by_id?category_id=6&format=json")
    Call<ArrayList<Newsn>> getNewsn();
}
