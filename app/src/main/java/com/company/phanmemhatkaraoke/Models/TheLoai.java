package com.company.phanmemhatkaraoke.Models;

public class TheLoai {
    private int id;
    private String tenTheLoai, hinhAnh;

    public TheLoai() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTenTheLoai() {
        return tenTheLoai;
    }

    public void setTenTheLoai(String tenTheLoai) {
        this.tenTheLoai = tenTheLoai;
    }

    public String getHinhAnh() {
        return hinhAnh;
    }

    public void setHinhAnh(String hinhAnh) {
        this.hinhAnh = hinhAnh;
    }

    public TheLoai(int id, String tenTheLoai, String hinhAnh) {
        this.id = id;
        this.tenTheLoai = tenTheLoai;
        this.hinhAnh = hinhAnh;
    }
}
