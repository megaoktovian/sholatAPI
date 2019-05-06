package com.example.sholatapi.view;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
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
    private DataItem dataItem;
    private String address = "Yogyakarta";
    private String method ="2";
    private String month = "5";
    private String year = "2019";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        A = findViewById(R.id.rec_artikel);
        mainPresenter = new MainPresenter(this, this);
        mainPresenter.loadSholat( address,  method,  month, year);
    }

    @Override
    public void onSucces(List<DataItem> dataItem) {
        adapter = new Adapter(getApplicationContext(), dataItem, this);
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

    @Override
    public void detail(DataItem dataItem) {
        Intent intent = new Intent(this, ItemDetail.class);
        intent.putExtra("date", dataItem.getDate().getReadable());
        intent.putExtra("shubuh", dataItem.getTimings().getFajr());
        intent.putExtra("dhuhur", dataItem.getTimings().getDhuhr());
        intent.putExtra("ashar", dataItem.getTimings().getAsr());
        intent.putExtra("maghrib", dataItem.getTimings().getMaghrib());
        intent.putExtra("isya", dataItem.getTimings().getIsha());
       startActivity(intent);
        Toast.makeText(this, dataItem.getDate().getReadable(), Toast.LENGTH_SHORT).show();

    }
}

