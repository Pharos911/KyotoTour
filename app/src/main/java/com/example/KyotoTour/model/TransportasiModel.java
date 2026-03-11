package com.example.KyotoTour.model;

public class TransportasiModel {

    private int idListGambarTransportasi, idListDesTransportasi, idListFeeTransportasi ,idListRuteTransportasi, idListTiketTransportasi, idListMapTransportasi;
    private String idListNamaTransportasi;

    public TransportasiModel(int idListGambarTransportasi, String idListNamaTransportasi , int idListDesTransportasi, int idListFeeTransportasi, int idListRuteTransportasi, int idListTiketTransportasi, int idListMapTransportasi){
        //   atribut/var              = parameter
        this.idListGambarTransportasi = idListGambarTransportasi;
        this.idListNamaTransportasi = idListNamaTransportasi;
        this.idListDesTransportasi = idListDesTransportasi;
        this.idListFeeTransportasi = idListFeeTransportasi;
        this.idListRuteTransportasi = idListRuteTransportasi;
        this.idListTiketTransportasi = idListTiketTransportasi;
        this.idListMapTransportasi = idListMapTransportasi;
    }

    public int getIdListGambarTransportasi() {
        return idListGambarTransportasi;
    }

    public String getIdListNamaTransportasi() { return  idListNamaTransportasi; }

    public int getIdListDesTransportasi() { return  idListDesTransportasi; }

    public int getIdListFeeTransportasi() { return  idListFeeTransportasi; }

    public int getIdListRuteTransportasi() { return  idListRuteTransportasi; }

    public int getIdListTiketTransportasi() { return  idListTiketTransportasi; }

    public int getIdListMapTransportasi() { return  idListMapTransportasi; }

}
