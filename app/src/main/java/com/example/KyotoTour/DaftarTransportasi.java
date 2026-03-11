package com.example.KyotoTour;

import com.example.KyotoTour.model.TransportasiModel;

import java.util.ArrayList;
import java.util.List;

public class DaftarTransportasi {
    public DaftarTransportasi() {
    }

    //TODO
    public List<TransportasiModel> listTransportasi(){
        List<TransportasiModel> listModel = new ArrayList<>();
        listModel.addAll(listTransportasiKereta());
        listModel.addAll(listTransportasiBus());
        return listModel;
    }

    public List<TransportasiModel> listTransportasiKereta(){
        List<TransportasiModel> listModel = new ArrayList<>();
        listModel.add(new TransportasiModel(R.drawable.t_karasumaline, "Subway Karasuma Line", R.string.des_karasumaline, R.string.fee_karasumaline, R.string.rute_karasumaline, R.string.tiket_karasumaline, R.drawable.tm_karasumaline));
        listModel.add(new TransportasiModel(R.drawable.t_tozailine, "Subway Tozai Line", R.string.des_tozailine, R.string.fee_tozailine, R.string.rute_tozailine, R.string.tiket_tozailine, R.drawable.tm_tozailine));
        listModel.add(new TransportasiModel(R.drawable.t_keifuku, "Keifuku Railway (Randen)", R.string.des_keifuku, R.string.fee_keifuku, R.string.rute_keifuku, R.string.tiket_keifuku, R.drawable.tm_keifuku));
        listModel.add(new TransportasiModel(R.drawable.t_keihan, "Keihan Railway", R.string.des_keihan, R.string.fee_keihan, R.string.rute_keihan, R.string.tiket_keihan, R.drawable.tm_keihan));
        listModel.add(new TransportasiModel(R.drawable.t_kintetsu, "Kintetsu Line", R.string.des_kintetsu, R.string.fee_kintetsu, R.string.rute_kintetsu, R.string.tiket_kintetsu, R.drawable.tm_kintetsu));
        listModel.add(new TransportasiModel(R.drawable.t_scenictrain, "Sagano Scenic Line (Romantic Train)", R.string.des_scenictrain, R.string.fee_scenictrain, R.string.rute_scenictrain, R.string.tiket_scenictrain, R.drawable.tm_scenictrain));
        listModel.add(new TransportasiModel(R.drawable.t_hankyu, "Hankyu Railway", R.string.des_hankyu, R.string.fee_hankyu, R.string.rute_hankyu, R.string.tiket_hankyu, R.drawable.tm_hankyu));
        listModel.add(new TransportasiModel(R.drawable.t_eizan, "Eizan Railway (Eiden)", R.string.des_eizan, R.string.fee_eizan, R.string.rute_eizan, R.string.tiket_eizan, R.drawable.tm_eizan));
        listModel.add(new TransportasiModel(R.drawable.t_jr, "JR (Japan Railway)", R.string.des_jr, R.string.fee_jr, R.string.rute_jr, R.string.tiket_jr, R.drawable.tm_jr));
        return listModel;
    }

    public List<TransportasiModel> listTransportasiBus(){
        List<TransportasiModel> listModel = new ArrayList<>();
        listModel.add(new TransportasiModel(R.drawable.b_kyotobus, "Kyoto Bus", R.string.des_kyotobus, R.string.fee_kyotobus, R.string.rute_kyotobus, R.string.tiket_kyotobus, R.drawable.bm_kyotobus));
        listModel.add(new TransportasiModel(R.drawable.b_keihanbus, "Keihan Bus", R.string.des_keihanbus, R.string.fee_keihanbus, R.string.rute_keihanbus, R.string.tiket_keihanbus, R.drawable.bm_keihanbus));
        listModel.add(new TransportasiModel(R.drawable.b_kyotocitybus, "Kyoto City Bus", R.string.des_kyocitybus, R.string.fee_kyocitybus, R.string.rute_kyocitybus, R.string.tiket_kyocitybus, R.drawable.m_bus));
        listModel.add(new TransportasiModel(R.drawable.b_jrbus, "JR Bus", R.string.des_jrbus, R.string.fee_jrbus, R.string.rute_jrbus, R.string.tiket_jrbus, R.drawable.bm_jrbus));
        return listModel;
    }
}
