package com.example.fsaoutput.controller;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.fsaoutput.R;

import static com.example.fsaoutput.R.id.jumlah;

public class DescActivity extends AppCompatActivity  implements View.OnClickListener {
    TextView nama, deskripsi;
    ImageView img;
    Button kurang, tambah;
    TextView isi,jumlah;
    int count = 0;

    String name;
    int photo;
    int harga;
    int cari;
    int jumlahStock;
    int tes;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_desc);
        kurang =findViewById(R.id.kurang);
        tambah =findViewById(R.id.tambah);
        isi =findViewById(R.id.isi);
        jumlah =findViewById(R.id.jumlah);
        Button btnMoveActivity = findViewById(R.id.order);
        btnMoveActivity.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hitung();
            }
        });

        nama =  findViewById(R.id.nama);
        deskripsi =  findViewById(R.id.deskripsi2);
        img = findViewById(R.id.gambar);

        name = getIntent().getStringExtra("nama");
        harga = getIntent().getIntExtra("deskripsi",-1);
        photo = getIntent().getIntExtra("gambar",-1);
        jumlahStock = getIntent().getIntExtra("stock",0);

        nama.setText(name);
        deskripsi.setText( "Harga : Rp." + (harga));

        Glide.with(DescActivity.this)
                .load(photo)
                .apply(new RequestOptions().override(370,370))
                .into(img);

    }

    public void increment(View view) {
        if (count == 0) {
            Toast.makeText(this, "pesanan minimal 1", Toast.LENGTH_SHORT).show();
            return;
        }

        count = count - 1;
        int a = count;
        int bb = harga;
        int cc = jumlahStock;
        //panggil variabel global
        cari = a * bb;
        tes = cc - a;

        display(count);
        total(cari);
        tampilan(tes);
    }
    public void decrement(View view) {
        if (count==50){
            Toast.makeText(this,"maksimal 50",Toast.LENGTH_SHORT).show();
            return;
        }
        count = count+1 ;
        int a = count;
        int bb = harga;
        int cc = jumlahStock;
        //panggil variabel global
        cari = a*bb;
        tes = cc - a;

        display(count);
        total(cari);
        tampilan(tes);
    }

    private void tampilan(int num){
        TextView hasil = findViewById(R.id.jumlah);
        hasil.setText(("" + num));
    }

    //method untuk get view dari count barang
    @SuppressLint("SetTextI18n")
    private void display(int number) {
        TextView quantityTextView =  findViewById(R.id.isi);
        quantityTextView.setText("" + number);
    }

    //method total untuk get data harus dibayar
    @SuppressLint("SetTextI18n")
    private void total(int num) {
        TextView Total =  findViewById(R.id.total);
        Total.setText("" + num);
    }

    //method hitung untuk parsing data dari sini ke uang activity
    public void hitung() {
        int totalz = cari;
        if(count < 1){
            Toast.makeText(getApplicationContext(), "pesanan minimal 1",
                    Toast.LENGTH_SHORT).show();
        }

        else{
            Intent intent = new Intent(DescActivity.this, uang.class);
            intent.putExtra("total", totalz);
            intent.putExtra("img",photo);
            intent.putExtra("nama",name);
            startActivity(intent);
            finish();
        }

    }


    @Override
    public void onClick(View v) {

        if (v.getId() == R.id.order) {
            Intent moveIntent = new Intent(DescActivity.this, uang.class);
            startActivity(moveIntent);
        }
    }
}
