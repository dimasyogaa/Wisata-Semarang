package com.yogadimas.wisatasemarang.view.history;

import android.annotation.SuppressLint;
import android.content.res.TypedArray;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.yogadimas.wisatasemarang.R;
import com.yogadimas.wisatasemarang.adapter.Adapter;
import com.yogadimas.wisatasemarang.model.Tours;

import java.util.ArrayList;

public class HistoryActivity extends AppCompatActivity {

    private final ArrayList<Tours> toursArrayList = new ArrayList<>();
    private RecyclerView rvTours;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);

        rvTours = findViewById(R.id.rv_tours);
        rvTours.setHasFixedSize(true);

        toursArrayList.addAll(getListTours());
        showRecyclerList();
    }

    public ArrayList<Tours> getListTours() {
        @SuppressLint("Recycle")
        TypedArray dataPhoto = getResources().obtainTypedArray(R.array.data_history_picture);
        String[] dataId = getResources().getStringArray(R.array.data_history_nature_id);
        String[] dataName = getResources().getStringArray(R.array.data_history_name);
        String[] dataDescription = getResources().getStringArray(R.array.data_history_description);

        ArrayList<Tours> listTours = new ArrayList<>();
        for (int i = 0; i < dataId.length; i++) {
            Tours tours = new Tours();
            tours.setPicture(dataPhoto.getResourceId(i, -1));
            tours.setId(dataId[i]);
            tours.setCategory("History");
            tours.setName(dataName[i]);
            tours.setDesc(dataDescription[i]);
            listTours.add(tours);
        }
        return listTours;
    }

    private void showRecyclerList() {
        rvTours.setLayoutManager(new LinearLayoutManager(this));
        Adapter adapter = new Adapter(toursArrayList);
        rvTours.setAdapter(adapter);
    }
}