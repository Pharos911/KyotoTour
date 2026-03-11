package com.example.KyotoTour.recyclekategori;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import com.example.KyotoTour.R;
import com.example.KyotoTour.model.TransportasiModel;

import java.util.ArrayList;
import java.util.List;

public class AdapterKategoriTransportasi extends RecyclerView.Adapter<AdapterKategoriTransportasi.AdapterKategoriTransportasiViewHolder> {

    List<TransportasiModel> list;
    List<TransportasiModel> listFull;

    public class AdapterKategoriTransportasiViewHolder extends RecyclerView.ViewHolder {
        public ImageView gambar;
        private TextView judul, deskripsi;

        public AdapterKategoriTransportasiViewHolder(@NonNull View itemView){
            super(itemView);
            gambar = itemView.findViewById(R.id.idImg);
            judul = itemView.findViewById(R.id.idJudul);
            deskripsi = itemView.findViewById(R.id.idDesk);
        }

        public void bind(final TransportasiModel transportasiModel, final AdapterKategoriTransportasi.OnItemClickListener listener){
            gambar.setImageResource(transportasiModel.getIdListGambarTransportasi());
            judul.setText(transportasiModel.getIdListNamaTransportasi());
            deskripsi.setText(transportasiModel.getIdListDesTransportasi());

            itemView.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View v){
                    if (listener !=null){
                        listener.onItemClicked(transportasiModel);
                    }
                }
            });
        }
    }

    public interface OnItemClickListener {
        public void onItemClicked(TransportasiModel transportasiModel);
    }

    private AdapterKategoriTransportasi.OnItemClickListener listener;

    public AdapterKategoriTransportasi(){
        list = new ArrayList<>();
        listFull = new ArrayList<>();
    }

    @Override
    public AdapterKategoriTransportasiViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType){
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item, parent, false);
        AdapterKategoriTransportasi.AdapterKategoriTransportasiViewHolder holder = new AdapterKategoriTransportasi.AdapterKategoriTransportasiViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterKategoriTransportasi.AdapterKategoriTransportasiViewHolder holder, int position){
        TransportasiModel transportasiModel = list.get(position);
        holder.bind(transportasiModel, listener);
    }

    @Override
    public int getItemCount() {return list.size();}

    public AdapterKategoriTransportasi(List<TransportasiModel> list, AdapterKategoriTransportasi.OnItemClickListener listener) {
        this.list = list;
        listFull = new ArrayList<>(list);
        this.listener = listener;
    }

    public List<TransportasiModel> getList() {
        return list;
    }

    public List<TransportasiModel> getListFull() {
        return listFull;
    }

    public void addItem(List<TransportasiModel> items) {
        list.addAll(items);
        listFull.addAll(items);
    }
}
