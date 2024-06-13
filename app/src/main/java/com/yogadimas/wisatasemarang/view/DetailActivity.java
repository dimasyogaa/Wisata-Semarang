package com.yogadimas.wisatasemarang.view;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.yogadimas.wisatasemarang.R;

public class DetailActivity extends AppCompatActivity implements View.OnClickListener {

    public static final String ID_TOUR = "id_tour";
    public static final String CATEGORY_TOUR = "category_tour";
    private int id;
    private String tourCategory;
    @SuppressLint("Recycle")
    private TypedArray dataPicture;
    private String[] dataName, dataDescription, dataMap, dataWeb;
    private TextView tvName, tvDesc;
    private ImageView ivPicture;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setNavigationIcon(R.drawable.ic_back);
        toolbar.setNavigationOnClickListener(v -> finish());

        ivPicture = findViewById(R.id.img_item_photo);
        tvName = findViewById(R.id.tv_name);
        tvDesc = findViewById(R.id.tv_desc);
        Button btnMap = findViewById(R.id.btn_map);
        Button btnWeb = findViewById(R.id.btn_web);

        String tourId = getIntent().getExtras().getString(ID_TOUR);
        tourCategory = getIntent().getExtras().getString(CATEGORY_TOUR);
        id = Integer.parseInt(tourId);

        loadDetailTour();

        btnMap.setOnClickListener(this);
        btnWeb.setOnClickListener(this);
    }

    private void loadDetailTour() {
        switch (tourCategory) {
            case "History":
                dataSource(R.array.data_history_picture, R.array.data_history_name, R.array.data_history_description, R.array.data_history_maps, R.array.data_history_web);
                break;
            case "Nature":
                dataSource(R.array.data_nature_picture, R.array.data_nature_name, R.array.data_nature_description, R.array.data_nature_maps, R.array.data_nature_web);
                break;
            case "Education":
                dataSource(R.array.data_education_picture, R.array.data_education_name, R.array.data_education_description, R.array.data_education_maps, R.array.data_education_web);
                break;
        }
        ivPicture.setImageResource(dataPicture.getResourceId(id, -1));
        tvName.setText(dataName[id]);
        tvDesc.setText(dataDescription[id]);
    }

    private void dataSource(int picture, int name, int desc, int map, int web) {
        dataPicture = getResources().obtainTypedArray(picture);
        dataName = getResources().getStringArray(name);
        dataDescription = getResources().getStringArray(desc);
        dataMap = getResources().getStringArray(map);
        dataWeb = getResources().getStringArray(web);
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.btn_map) {
            goToOtherActivity(dataMap[id]);
        } else {
            goToOtherActivity(dataWeb[id]);
        }

    }

    private void goToOtherActivity(String s) {
        Intent intent = new Intent(DetailActivity.this, WebViewActivity.class);
        intent.putExtra(WebViewActivity.LINK_WEB, s);
        startActivity(intent);
    }
}