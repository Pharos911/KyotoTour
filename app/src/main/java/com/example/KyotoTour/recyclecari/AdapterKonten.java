package com.example.KyotoTour.recyclecari;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.KyotoTour.R;
import com.example.KyotoTour.model.ItemModel;

import java.util.ArrayList;
import java.util.List;


public class AdapterKonten extends RecyclerView.Adapter<AdapterKonten.AdapterKontenViewHolder> implements Filterable {

    List<ItemModel> list;
    List<ItemModel> listFull;

    public class AdapterKontenViewHolder extends RecyclerView.ViewHolder{
        public ImageView gambar;
        private TextView judul, deskripsi;

        public AdapterKontenViewHolder(@NonNull View itemView) {
            super(itemView);
            gambar = itemView.findViewById(R.id.idImg);
            judul = itemView.findViewById(R.id.idJudul);
            deskripsi = itemView.findViewById(R.id.idDesk);
        }

        public void bind(final ItemModel itemModel, final OnItemClickListener listener) {
            gambar.setImageResource(itemModel.getIdListGambar());
            judul.setText(itemModel.getIdListNama());
            deskripsi.setText(itemModel.getIdListDeskripsi());

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (listener != null) {
                        listener.onItemClicked(itemModel);
                    }
                }
            });
        }
    }

    //menangani klik item di tempat recycleview digunakan, use : ListKonten.java
    public interface OnItemClickListener {
        public void onItemClicked(ItemModel itemModel);
    }

    private OnItemClickListener listener;   //deklarasi variabel listener untuk antisipasi klik

    public AdapterKonten(List<ItemModel> list, OnItemClickListener listener) {
        this.list = list;                   // menyimpan data dari variabel list yang ada di listkonten.java
        listFull = new ArrayList<>(list);   //data salinan lengkap dari list
        this.listener = listener;           //klik item
    }

    // getter yang akan dipakai pada percabangan ListKonten.java
    public List<ItemModel> getList() {
        return list;
    }


    //cara kerja : jika belum ada masukan maka listfull akan menampilkan seluruh konten
    //jika ada masukan berupa nama, filter akan bekerja menampilkan filterresult berdasarkan result.values yang ditampilkan oleh list
    //filter hanya bekerja pada list, sedangkan listfull datanya tetap. maka jika tidak ada masukan listfull lah yang akan dipanggil
    private Filter filter = new Filter() {
        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
            final List<ItemModel> filteredList = new ArrayList<>();
            final String str = constraint.toString().toLowerCase();
            if (constraint == null || constraint.length() == 0) {
                filteredList.addAll(listFull);
            } else {
                for (ItemModel itemModel : listFull) {
                    if (itemModel.getIdListNama().toLowerCase().contains(str)) {
                        filteredList.add(itemModel);
                    }
                }
            }
            FilterResults results = new FilterResults();
            results.values = filteredList;
            return results;
        }

        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {
            list.clear();
            list.addAll((List) results.values);
            notifyDataSetChanged();
        }
    };

    //fungsi geter menerima masukan dari listkomen.java, lalu menjalankan fungsi filter
    @Override
    public Filter getFilter() {
        return filter;
    }


    //menampilkan viewholder ke recycleview
    @Override
    public AdapterKonten.AdapterKontenViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item, parent, false);
        AdapterKontenViewHolder holder = new AdapterKontenViewHolder(view);
        return holder;
    }

    //mengisi data tiap viewholder
    @Override
    public void onBindViewHolder(@NonNull AdapterKonten.AdapterKontenViewHolder itemHolder, int position) {
        ItemModel item = list.get(position);
        itemHolder.bind(item, listener);

    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}
