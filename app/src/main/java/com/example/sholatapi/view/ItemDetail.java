package com.example.sholatapi.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.sholatapi.R;

public class ItemDetail extends AppCompatActivity {
    private TextView tvDate,tvShubuh,tvAshar,tvDhuhur,tvMaghrib,tvIsya;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_detail);
        tvDate = findViewById(R.id.tv_date);
        tvShubuh = findViewById(R.id.tv_shubuh);
        tvDhuhur = findViewById(R.id.tv_dhuhur);
        tvAshar = findViewById(R.id.tv_ashar);
        tvMaghrib = findViewById(R.id.tv_maghrib);
        tvIsya = findViewById(R.id.tv_isya);

        String date = getIntent().getStringExtra("date");
        String shubuh = getIntent().getStringExtra("shubuh");
        String dhuhur = getIntent().getStringExtra("dhuhur");
        String ashar = getIntent().getStringExtra("ashar");
        String maghrib = getIntent().getStringExtra("maghrib");
        String isya = getIntent().getStringExtra("isya");



        tvDate.setText(date);
        tvShubuh.setText(shubuh);
        tvDhuhur.setText(dhuhur);
        tvAshar.setText(ashar);
        tvMaghrib.setText(maghrib);
        tvIsya.setText(isya);


    }
}
