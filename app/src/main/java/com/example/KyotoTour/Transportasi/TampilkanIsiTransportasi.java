package com.example.KyotoTour.Transportasi;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import androidx.appcompat.app.ActionBar;

import android.text.method.LinkMovementMethod;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.KyotoTour.R;

public class TampilkanIsiTransportasi extends AppCompatActivity {
    private ImageView gambar, map;
    private TextView judul, deskripsi, fee, rute, tiket;
    ActionBar kembali;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tampilkan_isi_transportasi);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle(" ");

        kembali = getSupportActionBar();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        gambar = findViewById(R.id.idTampilGambar);
        judul = findViewById(R.id.idJudulTampil);
        deskripsi = findViewById(R.id.idDeskripsiTampil);
        fee = findViewById(R.id.idisifee);
        rute = findViewById(R.id.idisirute);
        tiket = findViewById(R.id.idisitiket);
        map = findViewById(R.id.idTampilmap);

        int idGambar = getIntent().getIntExtra("id_gambar",R.drawable.tips1);
        String idJudul = getIntent().getStringExtra("id_judul");
        int idDes = getIntent().getIntExtra("id_des",R.string.deks_default);
        int idfee = getIntent().getIntExtra("id_fee",R.string.deks_default);
        int idrute = getIntent().getIntExtra("id_rute",R.string.deks_default);
        int idtiket = getIntent().getIntExtra("id_tiket",R.string.deks_default);
        int idmap = getIntent().getIntExtra("id_map",R.drawable.tips1);

        gambar.setImageResource(idGambar);
        judul.setText(idJudul);
        deskripsi.setText(idDes);
        fee.setText(idfee);
        rute.setText(idrute);
        tiket.setText(idtiket);
        map.setImageResource(idmap);
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