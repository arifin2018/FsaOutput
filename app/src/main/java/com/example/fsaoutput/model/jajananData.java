package com.example.fsaoutput.model;

import com.example.fsaoutput.R;

import java.util.ArrayList;
//untuk membuat/menampung data secara lokal
public class jajananData {
    private static String[] jajananNames = {
            "Bear Brand",
            "Frisian Flag Coklat",
            "Frisian Flag Strawberry",
            "BengBeng",
            "Chuba",
            "Hydro coco",
            "Milo",
            "Mizone",
            "Pocari",
            "PopMie",
            "Taro",
    };

    private static int[] jajananDeskripsi = {
            6000,
            5000,
            5500,
            2000,
            1000,
            7000,
            7500,
            5500,
            5000,
            5500,
            7000,
    };

    private static int[] jajananStok = {
            60,
            50,
            55,
            200,
            100,
            70,
            75,
            55,
            50,
            55,
            70,
    };

    private static int[] jajananImages = {
            R.drawable.bearbr,
            R.drawable.bendera,
            R.drawable.benderapink,
            R.drawable.bengbeng,
            R.drawable.chuba,
            R.drawable.hydro,
            R.drawable.milo,
            R.drawable.mizone,
            R.drawable.pocari,
            R.drawable.pop,
            R.drawable.taro,
    };

    public static ArrayList<jajanan> getListData(){
        ArrayList<jajanan> list = new ArrayList<>();
        for (int position = 0; position < jajananNames.length; position++) {
            jajanan Jajanan = new jajanan();
            Jajanan.setName(jajananNames[position]);
            Jajanan.setDeskripsi(jajananDeskripsi[position]);
            Jajanan.setPhoto(jajananImages[position]);
            Jajanan.setStock(jajananStok[position]);
            list.add(Jajanan);
        }
        return list;
    }
}
