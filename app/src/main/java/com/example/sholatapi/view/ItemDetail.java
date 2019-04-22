package com.example.sholatapi.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.sholatapi.R;

public class ItemDetail extends AppCompatActivity {
    private TextView tv_date;
    private TextView tv_meta;
    private TextView tv_timings;
    private String a,b,c;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_detail);
        tv_date = findViewById(R.id.tv_date);
        tv_meta = findViewById(R.id.tv_meta);
        tv_timings = findViewById(R.id.tv_timings);

        a = getIntent().getStringExtra("date");
        b = getIntent().getStringExtra("meta");
        c = getIntent().getStringExtra("timings");

        tv_date.setText(a);
        tv_meta.setText(b);
        tv_timings.setText(c);

    }
}
