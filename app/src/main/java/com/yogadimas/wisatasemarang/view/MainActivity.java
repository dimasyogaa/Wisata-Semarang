package com.yogadimas.wisatasemarang.view;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.yogadimas.wisatasemarang.R;
import com.yogadimas.wisatasemarang.view.education.EducationActivity;
import com.yogadimas.wisatasemarang.view.history.HistoryActivity;
import com.yogadimas.wisatasemarang.view.nature.NatureActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnHistory = findViewById(R.id.btn_history);
        Button btnNature = findViewById(R.id.btn_nature);
        Button btnEducation = findViewById(R.id.btn_education);
        Button btnWeb = findViewById(R.id.btn_web);

        btnHistory.setOnClickListener(this);
        btnNature.setOnClickListener(this);
        btnEducation.setOnClickListener(this);
        btnWeb.setOnClickListener(this);
    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_history:
                goToOtherActivity(HistoryActivity.class);
                break;
            case R.id.btn_nature:
                goToOtherActivity(NatureActivity.class);
                break;
            case R.id.btn_education:
                goToOtherActivity(EducationActivity.class);
                break;
            case R.id.btn_web:
                Intent intent = new Intent(MainActivity.this, WebViewActivity.class);
                intent.putExtra(WebViewActivity.LINK_WEB, "https://infowisata.semarangkota.go.id");
                startActivity(intent);
                break;
        }
    }

    private void goToOtherActivity(Class<?> cls) {
        Intent intent = new Intent(MainActivity.this, cls);
        startActivity(intent);
    }
}