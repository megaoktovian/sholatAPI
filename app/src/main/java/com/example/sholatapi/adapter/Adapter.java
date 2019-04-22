package com.example.sholatapi.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.sholatapi.R;
import com.example.sholatapi.model.DataItem;
import com.example.sholatapi.view.ItemDetail;

import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.Holder> {
    private List<DataItem> dataItems;
    private Context context;

    public Adapter( Context context, List<DataItem> dataItems) {
        this.dataItems = dataItems;
        this.context = context;
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
        private TextView tv_date, tv_meta, tv_timings;
        public Holder(@NonNull View itemView) {
            super(itemView);
            tv_date = itemView.findViewById(R.id.tv_date);
            tv_meta = itemView.findViewById(R.id.tv_meta);
            tv_timings = itemView.findViewById(R.id.tv_timings);

            open_D = itemView.findViewById(R.id.open_Detail);
        }

        public void bind(final int i) {
            tv_date.setText(dataItems.get(i).getDate().toString());
            tv_meta.setText(dataItems.get(i).getMeta().toString());
            tv_timings.setText(dataItems.get(i).getTimings().toString());

            open_D.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent x = new Intent(context, ItemDetail.class);
                    x.putExtra("date", dataItems.get(i).getDate().toString());
                    x.putExtra("meta", dataItems.get(i).getMeta().toString());
                    x.putExtra("timings", dataItems.get(i).getTimings().toString());

                    x.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    context.startActivity(x);
                    Toast.makeText(context, dataItems.get(i).getDate().toString(), Toast.LENGTH_SHORT).show();
                }
            });
        }
    }
}
