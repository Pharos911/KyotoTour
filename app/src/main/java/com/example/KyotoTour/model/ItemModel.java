package com.example.KyotoTour.model;

public class ItemModel {

    private int idListGambar, idListDeskripsi, idListlok, idListaks, idListwak, idListfee, idListdae, idListlink, idListkor;
    private String idListNama;

    public ItemModel(int idListGambar, String idListNama, int idListDeskripsi, int idListlok, int idListaks, int idListwak, int idListfee, int idListdae, int idListlink, int idListkor) {
        //   atribut/var  = parameter
        this.idListGambar = idListGambar;
        this.idListNama = idListNama;
        this.idListDeskripsi = idListDeskripsi;
        this.idListlok = idListlok;
        this.idListaks = idListaks;
        this.idListwak = idListwak;
        this.idListfee = idListfee;
        this.idListdae = idListdae;
        this.idListlink = idListlink;
        this.idListkor = idListkor;
    }

    public int getIdListGambar() {
        return idListGambar;
    }

    public String getIdListNama() {
        return idListNama;
    }

    public int getIdListDeskripsi() {
        return idListDeskripsi;
    }

    public int getIdListlok() { return idListlok; }

    public int getIdListaks() {
        return idListaks;
    }

    public int getIdListwak() {
        return idListwak;
    }

    public int getIdListfee() {
        return idListfee;
    }

    public int getIdListdae() {
        return idListdae;
    }

    public int getIdListlink() {
        return idListlink;
    }

    public int getIdListkor() { return idListkor; }

}
