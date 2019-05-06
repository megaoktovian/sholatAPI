package com.example.sholatapi.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.sholatapi.R;
import com.example.sholatapi.model.DataItem;
import com.example.sholatapi.presenter.MainView;
import com.example.sholatapi.view.ItemDetail;

import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.Holder> {
    private List<DataItem> dataItems;
    private Context context;
    private MainView mainView;

    public Adapter(Context context, List<DataItem> dataItems, MainView mainView) {
        this.dataItems = dataItems;
        this.context = context;
        this.mainView = mainView;
    }

    @NonNull
    @Override
    public Adapter.Holder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item, parent, false);
        return new Holder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Adapter.Holder holder, final int i) {
        holder.bind(i);
    }

    @Override
    public int getItemCount() {
        return dataItems.size();
    }

    public class Holder extends RecyclerView.ViewHolder {
        private RelativeLayout open_D;
        TextView tvDate, tvShubuh, tvAshar, tvDhuhur, tvMaghrib, tvIsya;


        public Holder(@NonNull View itemView) {
            super(itemView);
            tvDate = itemView.findViewById(R.id.tv_date);
            tvShubuh = itemView.findViewById(R.id.tv_shubuh);
            tvDhuhur = itemView.findViewById(R.id.tv_dhuhur);
            tvAshar = itemView.findViewById(R.id.tv_ashar);
            tvMaghrib = itemView.findViewById(R.id.tv_maghrib);
            tvIsya = itemView.findViewById(R.id.tv_isya);
        }

        public void bind(final int i) {
            tvDate.setText(dataItems.get(i).getDate().getReadable());
            tvShubuh.setText(dataItems.get(i).getTimings().getFajr());
            tvDhuhur.setText(dataItems.get(i).getTimings().getDhuhr());
            tvAshar.setText(dataItems.get(i).getTimings().getAsr());
            tvMaghrib.setText(dataItems.get(i).getTimings().getMaghrib());
            tvIsya.setText(dataItems.get(i).getTimings().getIsha());
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                   mainView.detail(dataItems.get(i));
                }
            });

        }

    }
}
