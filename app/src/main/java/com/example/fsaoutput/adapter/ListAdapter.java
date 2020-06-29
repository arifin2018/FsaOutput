package com.example.fsaoutput.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.fsaoutput.R;
import com.example.fsaoutput.controller.DescActivity;
import com.example.fsaoutput.controller.transaksiSukses;
import com.example.fsaoutput.model.jajanan;

import java.util.ArrayList;

public class ListAdapter extends RecyclerView.Adapter<ListAdapter.ListViewHolder> {
    private ArrayList<jajanan> listJajanan;
    private Context context;

    public ListAdapter(ArrayList<jajanan> list) {
        this.listJajanan = list;
    }

    @NonNull
    @Override
    public ListViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_player, viewGroup, false);
        return new ListViewHolder(view);

    }


    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull final ListViewHolder holder, int position) {
        final jajanan Jajanan = listJajanan.get(position);
        Glide.with(holder.itemView.getContext())
                .load(Jajanan.getPhoto())
                .apply(new RequestOptions().override(55, 55))
                .into(holder.imgPhoto);
        holder.tvName.setText(Jajanan.getName());
        holder.tvDetail.setText("Harga = Rp." + Jajanan.getDeskripsi());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intents = new Intent(context, DescActivity.class);
                intents.putExtra("nama",Jajanan.getName());
                intents.putExtra("deskripsi",Jajanan.getDeskripsi());
                intents.putExtra("gambar",Jajanan.getPhoto());
                Bundle bundle = new Bundle();
                bundle.putString("nama2",Jajanan.getName());
                bundle.putInt("deskripsi3",Jajanan.getDeskripsi());
                bundle.putInt("gambar2",Jajanan.getPhoto());
                Intent intent = new Intent(context, transaksiSukses.class);
                intent.putExtras(bundle);
                context.startActivity(intents,bundle);
                Toast.makeText(holder.itemView.getContext(), "anda memilih " + listJajanan.get(holder.getAdapterPosition()).getName(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return listJajanan.size();
    }

    public class ListViewHolder extends RecyclerView.ViewHolder {
        ImageView imgPhoto;
        TextView tvName, tvDetail;

        public ListViewHolder(@NonNull View itemView) {
            super(itemView);
            context = itemView.getContext();
            imgPhoto = itemView.findViewById(R.id.img_item_photo);
            tvName = itemView.findViewById(R.id.tv_item_name);
            tvDetail = itemView.findViewById(R.id.tv_item_detail);
        }
    }
}
