package com.company.phanmemhatkaraoke.Models;

public class BaiHat {

       private int id;
       private String tenBaiHat,idTheLoai,youtube,luotHat,tenTheLoai;

       public BaiHat(int id, String tenBaiHat, String idTheLoai, String youtube, String luotHat, String tenTheLoai) {
              this.id = id;
              this.tenBaiHat = tenBaiHat;
              this.idTheLoai = idTheLoai;
              this.youtube = youtube;
              this.luotHat = luotHat;
              this.tenTheLoai = tenTheLoai;
       }

       public BaiHat() {
       }

       public int getId() {
              return id;
       }

       public void setId(int id) {
              this.id = id;
       }

       public String getTenBaiHat() {
              return tenBaiHat;
       }

       public void setTenBaiHat(String tenBaiHat) {
              this.tenBaiHat = tenBaiHat;
       }

       public String getIdTheLoai() {
              return idTheLoai;
       }

       public void setIdTheLoai(String idTheLoai) {
              this.idTheLoai = idTheLoai;
       }

       public String getYoutube() {
              return youtube;
       }

       public void setYoutube(String youtube) {
              this.youtube = youtube;
       }

       public String getLuotHat() {
              return luotHat;
       }

       public void setLuotHat(String luotHat) {
              this.luotHat = luotHat;
       }

       public String getTenTheLoai() {
              return tenTheLoai;
       }

       public void setTenTheLoai(String tenTheLoai) {
              this.tenTheLoai = tenTheLoai;
       }
}
