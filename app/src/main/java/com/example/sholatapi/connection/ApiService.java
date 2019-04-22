package com.example.sholatapi.connection;

import com.example.sholatapi.model.SholatResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiService {
    @GET("/v1/calendarByAddress")
    Call<SholatResponse> getSholat();
}
