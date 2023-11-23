package com.example.lec7demo;

import android.graphics.Color;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;


public class imgRecyclerAdapter extends RecyclerView.Adapter<imgRecyclerAdapter.ImageViewHolder> {
    List<GalleryImg> adapterImg;
    int SelectedInd;
    OnItemClickListener onItemClickListener;

    public imgRecyclerAdapter(List<GalleryImg> adapterImg, OnItemClickListener onItemCLickListener) {
        this.adapterImg = adapterImg;
        this.onItemClickListener = onItemCLickListener;
    }

    public imgRecyclerAdapter(List<GalleryImg> adapterImg) {

        this.adapterImg = adapterImg;
        this.SelectedInd = -1;
    }

    public List<GalleryImg> getAdapterImg() {
        return adapterImg;
    }

    public void setAdapterImg(List<GalleryImg> adapterImg) {
        this.adapterImg = adapterImg;
    }

    public int getSelectedInd() {
        return SelectedInd;
    }

    public void setSelectedInd(int selectedInd) {
        SelectedInd = selectedInd;
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
        holder.itemView.setBackgroundColor(Color.parseColor("#FAFAFA"));

        if(position==SelectedInd) {
            holder.itemView.setBackgroundColor(Color.LTGRAY);
        } else {
            holder.itemView.setBackgroundColor((Color.parseColor("#FAFAFA")));
        }
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

            imgViewItem.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    onItemClickListener.onItemClick(getAdapterPosition());
                    //itemView.setBackgroundColor(Color.LTGRAY);
                    SelectedInd = getAdapterPosition(); // if notifyDataChanged is called getAdapterPosition change to -1
                    //Toast.makeText(view.getContext(), "ID:" + SelectedInd, Toast.LENGTH_SHORT).show();
                    notifyDataSetChanged();
                }
            });


        }
    }
    public interface  OnItemClickListener{
        public void onItemClick(int i);
    }
}
