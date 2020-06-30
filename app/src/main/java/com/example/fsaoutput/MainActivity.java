package com.example.fsaoutput;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.example.fsaoutput.adapter.ListAdapter;
import com.example.fsaoutput.controller.About;
import com.example.fsaoutput.model.jajananData;
import com.example.fsaoutput.model.jajanan;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private RecyclerView rvJajanan;
    private ArrayList<jajanan> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        requestWindowFeature(Window.FEATURE_NO_TITLE);        untuk menghilangkan bar atas
//        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);

        rvJajanan = findViewById(R.id.rv_jajanan);
        rvJajanan.setHasFixedSize(true);

        list.addAll(jajananData.getListData());
        showRecyclerList();
        setActionBarTitle(title);
    }

    private void showRecyclerList() {
        rvJajanan.setLayoutManager(new LinearLayoutManager(this));
        ListAdapter listAdapter = new ListAdapter(list);
        rvJajanan.setAdapter(listAdapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
            switch (item.getItemId()) {
                case R.id.action_home:
                    title = "Home";
                    break;
                case R.id.action_about:
                    title = "About";
                    showAbout();
                    break;
                default:
                    return super.onOptionsItemSelected(item);
            }
        setActionBarTitle(title);
        return true;
    }

    private void showAbout() {
        Intent intent2 = new Intent(this, About.class);
        this.startActivity(intent2);
    }
    private String title = "Home";
    private void setActionBarTitle(String title) {
        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle(title);
        }
    }
}