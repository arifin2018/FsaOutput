package com.example.fsaoutput;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

import com.example.fsaoutput.adapter.ListAdapter;
import com.example.fsaoutput.model.jajananData;
import com.example.fsaoutput.model.jajanan;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private RecyclerView rvJajanan;
    private ArrayList<jajanan> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);

        rvJajanan = findViewById(R.id.rv_jajanan);
        rvJajanan.setHasFixedSize(true);

        list.addAll(jajananData.getListData());
        showRecyclerList();
    }

    private void showRecyclerList() {
        rvJajanan.setLayoutManager(new LinearLayoutManager(this));
        ListAdapter listAdapter = new ListAdapter(list);
        rvJajanan.setAdapter(listAdapter);
    }
    
}