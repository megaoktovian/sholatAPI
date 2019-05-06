package com.example.sholatapi.presenter;

import android.content.Context;

import com.example.sholatapi.connection.BaseApp;
import com.example.sholatapi.model.SholatResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainPresenter {
    private Context context;
    private MainView mainView;

    public MainPresenter(Context context, MainView mainView) {
        this.context = context;
        this.mainView = mainView;
    }
    public void loadSholat(String address, String method, String month, String year){
        BaseApp.service.getSholat( address,  method,  month, year).enqueue(new Callback<SholatResponse>() {
            @Override
            public void onResponse(Call<SholatResponse> call, Response<SholatResponse> response) {
                if (response.isSuccessful()){
                    mainView.onSucces(response.body().getData());
                } else {
                    mainView.onError(response.message());
                }
            }

            @Override
            public void onFailure(Call<SholatResponse> call, Throwable t) {
                mainView.onFailure(t.getMessage());
            }
        });
    }
}
