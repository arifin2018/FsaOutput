package com.example.fsaoutput.controller;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.example.fsaoutput.R;


public class uang extends AppCompatActivity{

    /*private ImageView foto;*/

    //inisialisasi widget button,textview, etc.
    Button btn_1,btn_2,btn_3,btn_4,btn_5,btn_6,btn_buy;
    TextView tv_balance,tv_reset,tv_ttl,getnama1;
    ImageView getimg1;

    String name;
    int photo;
    int totall;

    int count = 0;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState ) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.uang);

        //        foto = (ImageView) findViewById(R.id.foto);
        //        Animation myanim = AnimationUtils.loadAnimation(this,R.anim.myanim);
        //        foto.startAnimation(myanim);
        getnama1 = findViewById(R.id.getNama);
        getimg1 = findViewById(R.id.getImg);

        name = getIntent().getStringExtra("nama");
        photo =getIntent().getIntExtra("img",-1);

        getnama1.setText(name);
        getimg1.setImageResource(photo);

        if (getnama1.getText().equals("")){
            AlertDialog.Builder alert = new AlertDialog.Builder(getApplicationContext());
            alert.setTitle("Gagal...");
            alert.setMessage("Gagal load data...");
            alert.setPositiveButton("back", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    //intent
                }
            });
            alert.create().show();
        }

        btn_1 = findViewById(R.id.btn1);//variable button mencari layout button uang
        btn_2 = findViewById(R.id.btn2);//variable button mencari layout button uang
        btn_3 = findViewById(R.id.btn3);//variable button mencari layout button uang
        btn_4 = findViewById(R.id.btn4);//variable button mencari layout button uang
        btn_5 = findViewById(R.id.btn5);//variable button mencari layout button uang
        btn_6 = findViewById(R.id.btn6);//variable button mencari layout button uang
        btn_buy = findViewById(R.id.btn_buy);//variable button mencari layout button beli
        tv_balance = findViewById(R.id.tv_balance);//variable text view mencari layout text view uang
        tv_ttl = findViewById(R.id.ttl);//variable text view mencari layout text view total uang yang harus dibayar


        totall = getIntent().getIntExtra("total",-1);
        tv_ttl.setText("Total Harga Dibayar : Rp." +(totall));


        btn_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    count = count +500; //button uang decrement 500
                    display(count); //hasil di tampilakan ke display untuk di hitung ke number(count)
            }
        });

        btn_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                count = count +1000; //button uang decrement 500
                display(count); //hasil di tampilakan ke display untuk di hitung ke number(count)
            }
        });

        btn_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                count = count +2000; //button uang decrement 500
                display(count); //hasil di tampilakan ke display untuk di hitung ke number(count)
            }
        });

        btn_4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                count = count +5000; //button uang decrement 500
                display(count); //hasil di tampilakan ke display untuk di hitung ke number(count)
            }
        });

        btn_5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                count = count +10000; //button uang decrement 500
                display(count); //hasil di tampilakan ke display untuk di hitung ke number(count)
            }
        });

        btn_6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                count = count +50000; //button uang decrement 500
                display(count); //hasil di tampilakan ke display untuk di hitung ke number(count)
            }
        });

        tv_reset = findViewById(R.id.tv_reset);
        tv_reset.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {
                count = 0; //button uang reset 0 kembali
                display(count); //hasil di tampilakan ke display untuk di hitung ke number(count)
            }
        });

        btn_buy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int a = count;//count hasil dari perhitungan button
                int hitung = a - totall;
                if (totall == 0 || totall > a) { //jika nilai uang lebih kecil dari harga pesanan maka dia gagal
                    Toast.makeText(getApplicationContext(), "saldo anda tidak mencukupi",
                            Toast.LENGTH_SHORT).show(); // menampilkan pesan,pesanan gagal
                }
                else {

                    String get = tv_balance.getText().toString().trim();
                    Intent moveIntent = new Intent(uang.this,
                            transaksiSukses.class); //move activity uang to transaksuSukses
                    moveIntent.putExtra("nama2"   , name);
                    moveIntent.putExtra("photo2"  , photo);
                    moveIntent.putExtra("totalll" , totall);
                    moveIntent.putExtra("hitung"  , hitung);
                    Toast.makeText(getApplicationContext(), "Selamat,pesanan anda berhasil",
                            Toast.LENGTH_SHORT).show();
                    startActivity(moveIntent);
                }
            }
        });
    }
    @SuppressLint("SetTextI18n")
    public void display(int number)//numbernya hanya sebagai text,nilainya tetap dari count
    {
        tv_balance.setText("Balance : RP." + number); //tv_balance di tambah hasil uang yang di masukan oleh button
    }
}