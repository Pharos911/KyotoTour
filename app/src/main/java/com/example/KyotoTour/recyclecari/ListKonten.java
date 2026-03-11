package com.example.KyotoTour.recyclecari;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.widget.SearchView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.KyotoTour.DaftarSeluruhKonten;
import com.example.KyotoTour.R;
import com.example.KyotoTour.model.ItemModel;

import java.util.List;

public class ListKonten extends AppCompatActivity {

    private AdapterKonten adapterKonten;
    private List<ItemModel> list;
    private LinearLayoutManager linearLayoutManager;
    private boolean isFiltered = false;
    private RecyclerView recyclerView;
    String TAG = "ListKontenActivity";
    private DaftarSeluruhKonten daftarseluruhkonten;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_konten);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Cari Konten");
        final MediaPlayer suaraSplashScreen = MediaPlayer.create(this, R.raw.confirmsfxsatu);

        actionBar = getSupportActionBar();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        
        daftarseluruhkonten = new DaftarSeluruhKonten();
        list = daftarseluruhkonten.listData();                      //variabel list akan menyimpan seluruh data dari daftarseluruhkonten

        linearLayoutManager = new LinearLayoutManager(this); //mengatur layout (this) secara default vertikal
        recyclerView = findViewById(R.id.idRecycle1);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setHasFixedSize(true);
        adapterKonten = new AdapterKonten(list, listener);          //list yang menerima data dari daftarseluruhkonten.java akan dikirim ke adapterkonten dan antisiaspasi klik
        recyclerView.setAdapter(adapterKonten);                     //adapter pada recycleview yang digunakan pada halaman ini adapterkonten


        final SearchView searchView = (SearchView) findViewById(R.id.idCari2);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }                                                           //menekan tombol search pada keyboard

            @Override
            public boolean onQueryTextChange(String newText) {          //event dipanggil ketika tiap ada perubahan pada searchview
                Log.d(TAG, "onQueryTextChange: newtext " + newText);
                isFiltered = searchView.getQuery().length() > 0;
                adapterKonten.getFilter().filter(newText);              //mengirim masukan dari pengguna ke adapterkonten.java

                Log.d(TAG, "onCreate: List size didalem filter " + adapterKonten.getList().size());

                // jika hasil filter kurang dari 1, maka akan mencetak ini
                if (adapterKonten.getList().size() < 1) {
                    Toast.makeText(ListKonten.this, "Konten tidak ditemukan", Toast.LENGTH_SHORT).show();
                    suaraSplashScreen.start();
                }
                if (newText.equals("") || newText == null) {
                }
                return true;
            }
        });
    }

    private AdapterKonten.OnItemClickListener listener = new AdapterKonten.OnItemClickListener() {
        @Override
        public void onItemClicked(ItemModel itemModel) {
            Intent intent = new Intent(ListKonten.this, TampilkanIsiKonten.class);
            intent.putExtra("id_gambar", itemModel.getIdListGambar());
            intent.putExtra("id_judul", itemModel.getIdListNama());
            intent.putExtra("id_desk", itemModel.getIdListDeskripsi());
            intent.putExtra("id_lok", itemModel.getIdListlok());
            intent.putExtra("id_aks", itemModel.getIdListaks());
            intent.putExtra("id_wak", itemModel.getIdListwak());
            intent.putExtra("id_fee", itemModel.getIdListfee());
            intent.putExtra("id_dae", itemModel.getIdListdae());
            intent.putExtra("id_link", itemModel.getIdListlink());
            intent.putExtra("id_kor", itemModel.getIdListkor());
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