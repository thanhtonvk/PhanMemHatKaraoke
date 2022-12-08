package com.company.phanmemhatkaraoke.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.company.phanmemhatkaraoke.Database.DBContext;
import com.company.phanmemhatkaraoke.Models.TaiKhoan;
import com.company.phanmemhatkaraoke.R;

public class DangKyActivity extends AppCompatActivity {

    EditText edtTenTk, edtMatKhau, edtHoTen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dang_ky);
        anhXa();
        DBContext db = new DBContext(DangKyActivity.this);
        findViewById(R.id.btn_dang_ky).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TaiKhoan taiKhoan = new TaiKhoan();
                taiKhoan.setTenTK(edtTenTk.getText().toString());
                taiKhoan.setMatKhau(edtMatKhau.getText().toString());
                taiKhoan.setHoTen(edtHoTen.getText().toString());
                if (db.dangKy(taiKhoan) > 0) {
                    Toast.makeText(DangKyActivity.this, "Đăng ký tài khoản thành công", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(DangKyActivity.this, "Đăng ký tài không thành công, tài khoản đã tồn tại", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void anhXa() {
        edtTenTk = findViewById(R.id.edt_tentk);
        edtMatKhau = findViewById(R.id.edt_mk);
        edtHoTen = findViewById(R.id.edt_ten);
    }
}