package com.example.KyotoTour.InfoApp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.KyotoTour.R;

public class InfoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);
        setTitle("Tentang App Ini");
    }
}