package com.example.sholatapi.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.example.sholatapi.presenter.MainPresenter;
import com.example.sholatapi.presenter.MainView;
import com.example.sholatapi.R;
import com.example.sholatapi.adapter.Adapter;
import com.example.sholatapi.model.DataItem;
import com.example.sholatapi.presenter.MainPresenter;
import com.example.sholatapi.presenter.MainView;

import java.util.List;

public class MainActivity extends AppCompatActivity implements MainView {
    private RecyclerView A;
    private Adapter adapter;
    private MainPresenter mainPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        A = findViewById(R.id.rec_artikel);
        mainPresenter = new MainPresenter(this, this);
        mainPresenter.loadSholat();
    }

    @Override
    public void onSucces(List<DataItem> dataItemsItems) {
        adapter = new Adapter(getApplicationContext(), dataItemsItems);
        A.setLayoutManager(new LinearLayoutManager(this));
        A.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }

    @Override
    public void onError(String errorMessage) {
        Toast.makeText(this, errorMessage, Toast.LENGTH_LONG).show();
    }

    @Override
    public void onFailure(String failureMessage) {
        Toast.makeText(this, failureMessage, Toast.LENGTH_SHORT).show();
    }
}

