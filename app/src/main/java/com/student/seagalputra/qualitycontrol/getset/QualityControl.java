package com.student.seagalputra.qualitycontrol.getset;

import java.util.Date;

/**
 * Created by seagalputra on 5/8/18.
 */

public class QualityControl {
    private String idCek, idProduk, idPemesanan, tglQc, statusQc, kondisiWarna, kondisiSole;
    private int jumlahBarang;

    public QualityControl() {

    }

    public QualityControl(String idCek, String idProduk, String idPemesanan, String tglQc, String statusQc, int jumlahBarang, String kondisiWarna, String kondisiSole) {
        this.idCek = idCek;
        this.idProduk = idProduk;
        this.idPemesanan = idPemesanan;
        this.tglQc = tglQc;
        this.statusQc = statusQc;
        this.jumlahBarang = jumlahBarang;
        this.kondisiWarna = kondisiWarna;
        this.kondisiSole = kondisiSole;
    }

    public QualityControl(String idCek, String idProduk, String tglQc) {
        this.idCek = idCek;
        this.idProduk = idProduk;
        this.tglQc = tglQc;
    }

    public int getJumlahBarang() {
        return jumlahBarang;
    }

    public String getIdCek() {
        return idCek;
    }

    public String getIdPemesanan() {
        return idPemesanan;
    }

    public String getIdProduk() {
        return idProduk;
    }

    public String getKondisiSole() {
        return kondisiSole;
    }

    public String getKondisiWarna() {
        return kondisiWarna;
    }

    public String getStatusQc() {
        return statusQc;
    }

    public String getTglQc() {
        return tglQc;
    }

    public void setIdCek(String idCek) {
        this.idCek = idCek;
    }

    public void setIdPemesanan(String idPemesanan) {
        this.idPemesanan = idPemesanan;
    }

    public void setIdProduk(String idProduk) {
        this.idProduk = idProduk;
    }

    public void setJumlahBarang(int jumlahBarang) {
        this.jumlahBarang = jumlahBarang;
    }

    public void setKondisiSole(String kondisiSole) {
        this.kondisiSole = kondisiSole;
    }

    public void setKondisiWarna(String kondisiWarna) {
        this.kondisiWarna = kondisiWarna;
    }

    public void setStatusQc(String statusQc) {
        this.statusQc = statusQc;
    }

    public void setTglQc(String tglQc) {
        this.tglQc = tglQc;
    }
}