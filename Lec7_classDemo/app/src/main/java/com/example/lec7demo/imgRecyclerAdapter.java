package com.example.lec7demo;

import android.graphics.Color;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;


public class imgRecyclerAdapter extends RecyclerView.Adapter<imgRecyclerAdapter.ImageViewHolder> {
    List<GalleryImg> adapterImg;

    public imgRecyclerAdapter(List<GalleryImg> adapterImg) {
        this.adapterImg = adapterImg;
    }

    @NonNull
    @Override
    public ImageViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_item,parent,false);

        ImageViewHolder holder = new ImageViewHolder(itemView);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ImageViewHolder holder, int position) {
        holder.imgViewItem.setImageResource(adapterImg.get(position).getImgPic());
        holder.txtViewItem.setText(adapterImg.get(position).getImgName());
        holder.txtViewItem.setGravity(Gravity.CENTER);
        holder.itemView.setBackgroundColor(Color.parseColor("#f1a345"));
    }

    @Override
    public int getItemCount() {
        return adapterImg.size();
    }

    public class ImageViewHolder extends RecyclerView.ViewHolder{
        ImageView imgViewItem;
        TextView txtViewItem;

        public ImageViewHolder(@NonNull View itemView) {
            super(itemView);
            imgViewItem = itemView.findViewById(R.id.imgViewExtItem);
            txtViewItem = itemView.findViewById(R.id.txtViewExtItem);
        }
    }

}
