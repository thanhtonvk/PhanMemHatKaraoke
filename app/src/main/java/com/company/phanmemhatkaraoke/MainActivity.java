package com.company.phanmemhatkaraoke;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.company.phanmemhatkaraoke.Activity.DangKyActivity;
import com.company.phanmemhatkaraoke.Database.DBContext;
import com.company.phanmemhatkaraoke.Models.TaiKhoan;

public class MainActivity extends AppCompatActivity {

    EditText edtTk, edtMk;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        anhXa();
        DBContext db = new DBContext(this);

        findViewById(R.id.btn_dang_ky).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), DangKyActivity.class));
            }
        });
        findViewById(R.id.btn_dang_nhap).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (edtTk.getText().toString().equalsIgnoreCase("admin") && edtMk.getText().toString().equalsIgnoreCase("admin")) {
                    //admin
                } else {
                    TaiKhoan taiKhoan = db.dangNhap(edtTk.getText().toString(), edtMk.getText().toString());
                    if (taiKhoan != null) {
                        //nguoi dung
                    } else {
                        Toast.makeText(getApplicationContext(), "Tài khoản hoặc mật khẩu không chính xác", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }

    private void anhXa() {
        edtTk = findViewById(R.id.edt_tentk);
        edtMk = findViewById(R.id.edt_mk);

    }
}