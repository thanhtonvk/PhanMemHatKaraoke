package com.company.phanmemhatkaraoke.Database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.CursorWrapper;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.company.phanmemhatkaraoke.Models.BaiHat;
import com.company.phanmemhatkaraoke.Models.LichSu;
import com.company.phanmemhatkaraoke.Models.TaiKhoan;
import com.company.phanmemhatkaraoke.Models.TheLoai;

import java.util.ArrayList;
import java.util.List;

public class DBContext extends SQLiteOpenHelper {
    SQLiteDatabase database;

    public DBContext(@Nullable Context context) {
        super(context, "csdl.sqlite", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        //tạo bảng trong csdl
        sqLiteDatabase.execSQL("create table TaiKhoan(" +
                "TenTK nvarchar(50) primary key," +
                "MatKhau nvarchar(50)," +
                "HoTen nvarchar(100))");
        sqLiteDatabase.execSQL("create table TheLoai(" +
                "Id integer primary key autoincrement," +
                "TenTheLoai nvarchar(100)," +
                "HinhAnh ntext)");
        sqLiteDatabase.execSQL("create table BaiHat(" +
                "Id integer primary key autoincrement," +
                "TenBaiHat ntext," +
                "TheLoai integer," +
                "Youtube ntext," +
                "LuotHat int)");
        sqLiteDatabase.execSQL("create table LichSu(" +
                "Id integer primary key autoincrement," +
                "IdTaiKhoan integer," +
                "IdBaiHat integer)");
        database = getWritableDatabase();
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    //lấy về danh sách tài khoản
    public List<TaiKhoan> dsTaiKhoan() {

        Cursor cursor = database.rawQuery("select * from TaiKhoan", null);
        List<TaiKhoan> taiKhoans = new ArrayList<>();
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            TaiKhoan taiKhoan = new TaiKhoan(cursor.getString(0), cursor.getString(1), cursor.getString(2));
            taiKhoans.add(taiKhoan);
            cursor.moveToNext();
        }
        return taiKhoans;
    }

    //xóa tài khoản
    public long xoaTaiKhoan(String tenTK) {
        int[] arr = new int[]{1, 2, 3};

        return database.delete("TaiKhoan", "TenTK = ?", new String[]{tenTK});
    }

    public long dangKy(TaiKhoan taiKhoan) {

        ContentValues values = new ContentValues();
        values.put("TenTK", taiKhoan.getTenTK());
        values.put("MatKhau", taiKhoan.getMatKhau());
        values.put("HoTen", taiKhoan.getHoTen());
        return database.insert("TaiKhoan", null, values);
    }

    //đăng nhập
    public TaiKhoan dangNhap(String tenTK, String matKhau) {

        TaiKhoan taiKhoan = null;
        Cursor cursor = database.rawQuery("select * from TaiKhoan", null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            if (cursor.getString(0).equals(tenTK) && cursor.getString(1).equals(matKhau)) {
                taiKhoan = new TaiKhoan(cursor.getString(0), cursor.getString(1), cursor.getString(2));
                break;
            }
            cursor.moveToNext();
        }
        return taiKhoan;
    }

    //thể loại
    public List<TheLoai> dsTheLoai() {
        List<TheLoai> theLoaiList = new ArrayList<>();

        Cursor cursor = database.rawQuery("select * from TheLoai", null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            theLoaiList.add(new TheLoai(cursor.getInt(0), cursor.getString(1), cursor.getString(2)));
            cursor.moveToNext();
        }
        return theLoaiList;
    }

    public long themTheLoai(TheLoai theLoai) {
        ContentValues values = new ContentValues();

        values.put("TenTheLoai", theLoai.getTenTheLoai());
        values.put("HinhAnh", theLoai.getHinhAnh());
        return database.insert("TheLoai", null, values);
    }

    public long suaTheLoai(TheLoai theLoai) {

        ContentValues values = new ContentValues();

        values.put("TenTheLoai", theLoai.getTenTheLoai());
        values.put("HinhAnh", theLoai.getHinhAnh());
        return database.update("TheLoai", values, "Id=?", new String[]{String.valueOf(theLoai.getId())});
    }

    public long xoaTheLoai(int id) {
        return database.delete("TheLoai", "Id=?", new String[]{String.valueOf(id)});
    }

    //Bai hat
    public List<BaiHat> dsBaiHat() {
        List<BaiHat> baiHatList = new ArrayList<>();
        Cursor cursor = database.rawQuery("select BaiHat.Id,TenBaiHat,IdTheLoai,Youtube,LuotHat,TheLoai.TenTheLoai from BatHat,TheLoai where BaiHat.TheLoai = TheLoai.Id", null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            baiHatList.add(new BaiHat(cursor.getInt(0), cursor.getString(1), cursor.getString(2), cursor.getString(3), cursor.getString(4), cursor.getString(5)));
            cursor.moveToNext();
        }
        return baiHatList;
    }

    public BaiHat baiHat(int id) {
        BaiHat baiHat = null;
        for (BaiHat bh : dsBaiHat()) {
            if (bh.getId() == id) baiHat = bh;
        }
        return baiHat;
    }

    public long themBaiHat(BaiHat baiHat) {
        ContentValues values = new ContentValues();
        values.put("TenBaiHat", baiHat.getTenBaiHat());
        values.put("IdTheLoai", baiHat.getIdTheLoai());
        values.put("Youtube", baiHat.getYoutube());
        return database.insert("BaiHat", null, values);
    }

    public long suaBaiHat(BaiHat baiHat) {
        ContentValues values = new ContentValues();
        values.put("TenBaiHat", baiHat.getTenBaiHat());
        values.put("IdTheLoai", baiHat.getIdTheLoai());
        values.put("Youtube", baiHat.getYoutube());
        return database.update("BaiHat", values, "Id=?", new String[]{String.valueOf(baiHat.getId())});
    }

    public long xoaBaiHat(int id) {
        return database.delete("BaiHat", "Id=?", new String[]{String.valueOf(id)});
    }

    //lich su
    public List<LichSu> dsLichSu(String idTaiKhoan) {
        List<LichSu> lichSus = new ArrayList<>();
        Cursor cursor = database.rawQuery(String.format("select idBaiHat from LichSu,BaiHat where LichSu.IdTaiKhoan = %s and LichSu.IdBaiHat = BaiHat.Id", idTaiKhoan), null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            BaiHat baiHat = baiHat(cursor.getInt(0));
            LichSu lichSu = new LichSu();
            lichSu.setBaiHat(baiHat);
            lichSus.add(lichSu);
        }
        return lichSus;
    }

    public long addLichSu(int idTaiKhoan, int idBaiHat) {
        ContentValues values = new ContentValues();
        values.put("IdTaiKhoan", idTaiKhoan);
        values.put("IdBaiHat", idBaiHat);
        return database.insert("LichSu", null, values);
    }

}
