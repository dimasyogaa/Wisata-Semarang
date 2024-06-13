package com.yogadimas.wisatasemarang.adapter;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.yogadimas.wisatasemarang.R;
import com.yogadimas.wisatasemarang.model.Tours;
import com.yogadimas.wisatasemarang.view.DetailActivity;

import java.util.ArrayList;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {
    private final ArrayList<Tours> toursArrayList;

    public Adapter(ArrayList<Tours> toursArrayList) {
        this.toursArrayList = toursArrayList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_row_tour, parent, false);
        return new ViewHolder(view);
    }


    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Tours tours = toursArrayList.get(position);
        holder.ivPicture.setImageResource(tours.getPicture());
        holder.tvName.setText(tours.getName());
        holder.tvDescription.setText(tours.getDesc());
        holder.itemView.setOnClickListener(view -> {
            Intent intent = new Intent(holder.itemView.getContext(), DetailActivity.class);
            intent.putExtra(DetailActivity.ID_TOUR, tours.getId());
            intent.putExtra(DetailActivity.CATEGORY_TOUR, tours.getCategory());
            holder.itemView.getContext().startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return toursArrayList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private final ImageView ivPicture;
        private final TextView tvName, tvDescription;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ivPicture = itemView.findViewById(R.id.img_item_photo);
            tvName = itemView.findViewById(R.id.tv_item_name);
            tvDescription = itemView.findViewById(R.id.tv_item_description);
        }
    }
}
