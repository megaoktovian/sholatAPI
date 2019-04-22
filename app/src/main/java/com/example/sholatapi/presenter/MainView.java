package com.example.sholatapi.presenter;

import com.example.sholatapi.model.DataItem;

import java.util.List;

public interface MainView {
    void onSucces(List<DataItem> dataItems);

    void onError(String errorMessage);

    void onFailure(String failureMessage);
}
