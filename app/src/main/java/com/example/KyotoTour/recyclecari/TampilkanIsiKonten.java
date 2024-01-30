package com.example.KyotoTour.recyclecari;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.appcompat.app.ActionBar;

import android.text.method.LinkMovementMethod;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.widget.Toolbar;

import com.example.KyotoTour.model.ItemModel;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import com.example.KyotoTour.R;

public class TampilkanIsiKonten extends AppCompatActivity implements OnMapReadyCallback{

    private ImageView gambar;
    TextView judul, deskripsi, lokasi, akses, waktu, fee, daerah, tautan;
    ItemModel itemModel;
    GoogleMap googleMaps;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tampilkan_isi_konten);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle(" ");

        //show maps
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        gambar = findViewById(R.id.idTampilGambar);
        judul = findViewById(R.id.idJudulTampil);
        deskripsi = findViewById(R.id.idDeskripsiTampil);
        lokasi = findViewById(R.id.idisilok);
        akses = findViewById(R.id.idisiaks);
        waktu = findViewById(R.id.idisiwak);
        fee = findViewById(R.id.idisifee);
        daerah = findViewById(R.id.idisidae);
        tautan = findViewById(R.id.idisilink);

        tautan.setMovementMethod(LinkMovementMethod.getInstance());

        int idGambar = getIntent().getIntExtra("id_gambar",R.drawable.tips1);
        String idJudul = getIntent().getStringExtra("id_judul");
        int idDesk = getIntent().getIntExtra("id_desk",R.string.deks_default);
        int idLok = getIntent().getIntExtra("id_lok",R.string.deks_default);
        int idAks = getIntent().getIntExtra("id_aks",R.string.deks_default);
        int idWak = getIntent().getIntExtra("id_wak",R.string.deks_default);
        int idFee = getIntent().getIntExtra("id_fee",R.string.deks_default);
        int idDae = getIntent().getIntExtra("id_dae",R.string.deks_default);
        int idLink = getIntent().getIntExtra("id_link",R.string.deks_default);

        gambar.setImageResource(idGambar);
        judul.setText(idJudul);
        deskripsi.setText(idDesk);
        lokasi.setText(idLok);
        akses.setText(idAks);
        waktu.setText(idWak);
        fee.setText(idFee);
        daerah.setText(idDae);
        tautan.setText(idLink);

    }

    @Override
    public void onMapReady(GoogleMap googleMap) {

        //get LatLong
        //String[] latlong = itemModel.getIdListkor().split(",");
        //double latitude = Double.parseDouble(latlong[0]);
        //double longtitude = Double.parseDouble(latlong[1]);

        googleMaps = googleMap;
        LatLng latLng = new LatLng(55.1165, 26.555);
        googleMaps.addMarker(new MarkerOptions().position(latLng).title(String.valueOf(judul)));
        googleMaps.moveCamera(CameraUpdateFactory.newLatLng(latLng));
        googleMaps.moveCamera(CameraUpdateFactory.newLatLngZoom(latLng, 16));
        googleMaps.getUiSettings().setAllGesturesEnabled(true);
        googleMaps.getUiSettings().setZoomGesturesEnabled(true);
        googleMaps.setTrafficEnabled(true);

    }
}