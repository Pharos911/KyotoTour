package com.example.KyotoTour.Transportasi;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import androidx.appcompat.app.ActionBar;
import android.content.Intent;
import android.os.Bundle;

import com.example.KyotoTour.DaftarTransportasi;
import com.example.KyotoTour.model.TransportasiModel;
import com.example.KyotoTour.Transportasi.TampilkanIsiTransportasi;
import com.example.KyotoTour.recyclekategori.AdapterKategoriTransportasi;
import com.makeramen.roundedimageview.RoundedImageView;

import java.util.List;

import com.example.KyotoTour.R;

public class Transportasi extends AppCompatActivity {
    ActionBar actionBar;

    private RoundedImageView gambarKategoriStatic1;
    private List<TransportasiModel> list;
    private DaftarTransportasi daftarTransportasi;
    private AdapterKategoriTransportasi adapterKategoriTransportasi;
    private LinearLayoutManager linearLayoutManager;
    private RecyclerView recyclerView;
    String TAG = "KategoriKonten";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transportasi);
        daftarTransportasi = new DaftarTransportasi();
        gambarKategoriStatic1 = findViewById(R.id.idGambarKategoriStatic);
        setTitle(" ");

        actionBar = getSupportActionBar();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //TODO
        String transportasi = getIntent().getStringExtra("Transportasi");
        if(transportasi.equalsIgnoreCase("Kereta")){
            gambarKategoriStatic1.setImageResource(R.drawable.t_cover1);
            list = daftarTransportasi.listTransportasiKereta();
        } else if(transportasi.equalsIgnoreCase("Bus")){
            gambarKategoriStatic1.setImageResource(R.drawable.b_cover1);
            list = daftarTransportasi.listTransportasiBus();
        }

        linearLayoutManager = new LinearLayoutManager(this);
        recyclerView = findViewById(R.id.idRecycleKategori);
        recyclerView.setLayoutManager(linearLayoutManager);
        //recyclerView.setHasFixedSize(true);
        adapterKategoriTransportasi = new AdapterKategoriTransportasi(list, listener);
        recyclerView.setAdapter(adapterKategoriTransportasi);
    }

    private AdapterKategoriTransportasi.OnItemClickListener listener = new AdapterKategoriTransportasi.OnItemClickListener() {
        @Override
        public void onItemClicked(TransportasiModel transportasiModel) {
            Intent intent = new Intent(Transportasi.this, TampilkanIsiTransportasi.class);
            intent.putExtra("id_gambar", transportasiModel.getIdListGambarTransportasi());
            intent.putExtra("id_judul", transportasiModel.getIdListNamaTransportasi());
            intent.putExtra("id_des", transportasiModel.getIdListDesTransportasi());
            intent.putExtra("id_fee", transportasiModel.getIdListFeeTransportasi());
            intent.putExtra("id_rute", transportasiModel.getIdListRuteTransportasi());
            intent.putExtra("id_tiket", transportasiModel.getIdListTiketTransportasi());
            intent.putExtra("id_map", transportasiModel.getIdListMapTransportasi());
            startActivity(intent);
        }
    };
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