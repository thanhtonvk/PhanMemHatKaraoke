package com.company.phanmemhatkaraoke.Models;

public class LichSu {
    private int id, idTaiKhoan, idBaiHat;
    private BaiHat baiHat;

    public LichSu(int id, int idTaiKhoan, int idBaiHat, BaiHat baiHat) {
        this.id = id;
        this.idTaiKhoan = idTaiKhoan;
        this.idBaiHat = idBaiHat;
        this.baiHat = baiHat;
    }

    public LichSu() {
        this.idTaiKhoan = idTaiKhoan;
        this.idBaiHat = idBaiHat;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdTaiKhoan() {
        return idTaiKhoan;
    }

    public void setIdTaiKhoan(int idTaiKhoan) {
        this.idTaiKhoan = idTaiKhoan;
    }

    public int getIdBaiHat() {
        return idBaiHat;
    }

    public void setIdBaiHat(int idBaiHat) {
        this.idBaiHat = idBaiHat;
    }

    public BaiHat getBaiHat() {
        return baiHat;
    }

    public void setBaiHat(BaiHat baiHat) {
        this.baiHat = baiHat;
    }
}
