package com.example.KyotoTour;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.KyotoTour.InfoApp.InfoActivity;
import com.example.KyotoTour.Transportasi.Transportasi;
import com.example.KyotoTour.recyclecari.ListKonten;
import com.google.android.material.button.MaterialButton;
import com.makeramen.roundedimageview.RoundedImageView;


public class MainActivity extends AppCompatActivity {

    private MaterialButton btnCariBeranda, TentangApp;
    private RoundedImageView btnKategori1, btnKategori2, btnKategori3, btnKategori4, TentangKyoto, ShrinedanTample, TentangPrefektur, btntransportasi1, btntransportasi2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

        TentangApp = findViewById(R.id.idTentangApp);
        TentangApp.setOnClickListener(btnInfoClicked);

        TentangKyoto = findViewById(R.id.idTentangKyoto);
        TentangKyoto.setOnClickListener(btnTentangKyoto);

        ShrinedanTample = findViewById(R.id.idShrinedanTample);
        ShrinedanTample.setOnClickListener(btnShrinedanTample);

        TentangPrefektur = findViewById(R.id.idTentangPrefektur);
        TentangPrefektur.setOnClickListener(btnTentangPrefektur);


        btnCariBeranda = findViewById(R.id.btnCari_Beranda);
        btnCariBeranda.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ListKonten.class);
                startActivity(intent);
            }
        });

        btnKategori1 = findViewById(R.id.kategoriBeranda1);
        btnKategori1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, KategoriKonten.class);
                intent.putExtra("kategori", "Wisata");
                startActivity(intent);
            }
        });

        btnKategori2 = findViewById(R.id.kategoriBeranda2);
        btnKategori2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, KategoriKonten.class);
                intent.putExtra("kategori", "Kuil");
                startActivity(intent);
            }
        });

        btnKategori3 = findViewById(R.id.kategoriBeranda3);
        btnKategori3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, KategoriKonten.class);
                intent.putExtra("kategori", "Makanan");
                startActivity(intent);
            }
        });

        btnKategori4 = findViewById(R.id.kategoriBeranda4);
        btnKategori4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, KategoriKonten.class);
                intent.putExtra("kategori", "Festival");
                startActivity(intent);
            }
        });

        btntransportasi1 = findViewById(R.id.transportasi1);
        btntransportasi1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Transportasi.class);
                intent.putExtra("Transportasi", "Kereta");
                startActivity(intent);
            }
        });

        btntransportasi2 = findViewById(R.id.transportasi2);
        btntransportasi2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Transportasi.class);
                intent.putExtra("Transportasi", "Bus");
                startActivity(intent);
            }
        });

    }

    View.OnClickListener btnInfoClicked = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent(MainActivity.this, InfoActivity.class);
            startActivity(intent);
        }
    };

    View.OnClickListener btnTentangKyoto = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent(MainActivity.this, com.example.KyotoTour.InformasiTambahan.TentangKyoto.class);
            startActivity(intent);
        }
    };

    View.OnClickListener btnShrinedanTample = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent(MainActivity.this, com.example.KyotoTour.InformasiTambahan.ShrinedanTample.class);
            startActivity(intent);
        }
    };

    View.OnClickListener btnTentangPrefektur = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent(MainActivity.this, com.example.KyotoTour.InformasiTambahan.TentangPrefektur.class);
            startActivity(intent);
        }
    };

}