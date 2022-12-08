package com.company.phanmemhatkaraoke.Admin.Adapter;

import android.app.Dialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.company.phanmemhatkaraoke.Database.DBContext;
import com.company.phanmemhatkaraoke.Models.TheLoai;
import com.company.phanmemhatkaraoke.R;

import java.util.List;

public class TheLoaiAdapter extends RecyclerView.Adapter<TheLoaiAdapter.ViewHolder> {
    Context context;
    List<TheLoai> theLoaiList;
    DBContext dbContext;

    public TheLoaiAdapter(Context context, List<TheLoai> theLoaiList) {
        this.context = context;
        this.theLoaiList = theLoaiList;
        dbContext = new DBContext(context);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(context).inflate(R.layout.item_the_loai, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        TheLoai theLoai = theLoaiList.get(position);
        holder.tvTenTheLoai.setText(theLoai.getTenTheLoai());
        Glide.with(context).load(theLoai.getHinhAnh()).error(R.drawable.menu).into(holder.imgHinhAnh);
        holder.btnXoa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                theLoaiList.remove(theLoai);
                dbContext.xoaTheLoai(theLoai.getId());
                notifyDataSetChanged();
            }
        });
        holder.btnSua.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog(theLoai);
            }
        });
    }

    private void dialog(TheLoai theLoai) {
        int position = theLoaiList.indexOf(theLoai);
        Dialog dialog = new Dialog(context);
        dialog.setContentView(R.layout.item_the_loai);
        EditText edtTenTheLoai = dialog.findViewById(R.id.edt_ten_the_loai);
        EditText edtHinhAnh = dialog.findViewById(R.id.edt_hinh_anh);
        Button btnCapNhat = dialog.findViewById(R.id.btn_cap_nhat);
        edtTenTheLoai.setText(theLoai.getTenTheLoai());
        edtHinhAnh.setText(theLoai.getHinhAnh());
        btnCapNhat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                theLoai.setTenTheLoai(edtTenTheLoai.getText().toString());
                theLoai.setHinhAnh(edtHinhAnh.getText().toString());
                dbContext.suaTheLoai(theLoai);
                theLoaiList.set(position, theLoai);
                notifyDataSetChanged();
            }
        });
        dialog.show();
    }

    @Override
    public int getItemCount() {
        return theLoaiList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imgHinhAnh;
        TextView tvTenTheLoai;
        Button btnSua, btnXoa;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imgHinhAnh = itemView.findViewById(R.id.img_hinh_anh);
            tvTenTheLoai = itemView.findViewById(R.id.tv_ten_the_loai);
            btnSua = itemView.findViewById(R.id.btn_sua);
            btnXoa = itemView.findViewById(R.id.btn_xoa);
        }
    }
}
