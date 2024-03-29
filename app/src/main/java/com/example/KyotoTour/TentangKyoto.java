package com.example.KyotoTour;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.net.Uri;
import android.widget.MediaController;
import android.widget.VideoView;

import android.os.Bundle;

public class TentangKyoto extends AppCompatActivity {

    ActionBar actionBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tentang_kyoto);
        setTitle(" ");

        actionBar = getSupportActionBar();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        VideoView videoView = (VideoView) findViewById(R.id.idVideo2);
        videoView.setVideoURI(Uri.parse("android.resource://" + getPackageName()+"/"+R.raw.kotakyoto));

        MediaController mediaController = new MediaController(this);
        videoView.setMediaController(mediaController);
        mediaController.setAnchorView(videoView);
        videoView.start();
    }

    @Override
    public boolean onSupportNavigateUp(){
        onBackPressed();
        return true;
    }

    @Override
    public void onBackPressed(){
        super.onBackPressed();
    }
}