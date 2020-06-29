package com.example.fsaoutput.controller;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.fsaoutput.R;

public class transaksiSukses extends AppCompatActivity  {

    TextView nama2, deskripsi3,tv_kembalian;
    ImageView img2;

    String name;
    int photo;
    int harga;
    int kembalian;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transaksi_sukses);

            nama2 =  findViewById(R.id.nama2);
            deskripsi3 =  findViewById(R.id.deskripsi3);
            img2 = findViewById(R.id.gambar2);
            tv_kembalian = findViewById(R.id.productBuyChangeMoneyInfo);

            name = getIntent().getStringExtra("nama2");
            photo = getIntent().getIntExtra("photo2",-1);
            harga = getIntent().getIntExtra("totalll",-1);
            kembalian = getIntent().getIntExtra("hitung",-1);

            nama2.setText(name);
            img2.setImageResource(photo);
            deskripsi3.setText(Integer.toString(harga));
            tv_kembalian.setText(Integer.toString(kembalian));

        }
}