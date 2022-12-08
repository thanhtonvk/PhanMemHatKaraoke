package com.company.phanmemhatkaraoke.Models;

public class TaiKhoan {
    private String tenTK,matKhau,hoTen;

    public TaiKhoan(String tenTK, String matKhau, String hoTen) {
        this.tenTK = tenTK;
        this.matKhau = matKhau;
        this.hoTen = hoTen;
    }
    public TaiKhoan(){

    }

    public String getTenTK() {
        return tenTK;
    }

    public void setTenTK(String tenTK) {
        this.tenTK = tenTK;
    }

    public String getMatKhau() {
        return matKhau;
    }

    public void setMatKhau(String matKhau) {
        this.matKhau = matKhau;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }
}
