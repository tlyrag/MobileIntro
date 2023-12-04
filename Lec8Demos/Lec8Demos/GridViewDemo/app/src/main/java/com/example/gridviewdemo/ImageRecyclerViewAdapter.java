package com.example.gridviewdemo;

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

public class ImageRecyclerViewAdapter
        extends RecyclerView.Adapter<ImageRecyclerViewAdapter.ImageViewHolder> {
    //define data
    List<GalleryImage> AdapterImages;
    int SelectedInd;
    OnItemClickListener onItemClickListener;


    //define constructor

    public ImageRecyclerViewAdapter(List<GalleryImage> adapterImages,
                                    OnItemClickListener onItemClickListener) {
        AdapterImages = adapterImages;
        this.onItemClickListener = onItemClickListener;
        SelectedInd = -1;
    }

    public ImageRecyclerViewAdapter(List<GalleryImage> adapterImages) {
        AdapterImages = adapterImages;
        SelectedInd = -1;
    }

    //define getters and setters


    public List<GalleryImage> getAdapterImages() {
        return AdapterImages;
    }

    public void setAdapterImages(List<GalleryImage> adapterImages) {
        AdapterImages = adapterImages;
        SelectedInd = -1; //reset selection after new data
    }

    public int getSelectedInd() {
        return SelectedInd;
    }

    public void setSelectedInd(int selectedInd) {
        SelectedInd = selectedInd;
    }

    //implement methods
    @NonNull
    @Override
    public ImageViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                            .inflate(R.layout.layout_item,parent,false);
        ImageViewHolder holder = new ImageViewHolder(itemView);

        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ImageViewHolder holder, int position) {
        holder.imgViewItem
                .setImageResource(AdapterImages.get(position).getImgPic());
        holder.txtViewItem.setText(AdapterImages.get(position).getImgName());
        holder.txtViewItem.setGravity(Gravity.CENTER);
        holder.itemView.setBackgroundColor(Color.parseColor("#FAFAFA"));
        if (position == SelectedInd){
            holder.itemView.setBackgroundColor(Color.LTGRAY);
        } else {
            holder.itemView.setBackgroundColor(
                    Color.parseColor("#FAFAFA"));
        }
    }

    @Override
    public int getItemCount() {
        return AdapterImages.size();
    }


    public class ImageViewHolder extends RecyclerView.ViewHolder {
        ImageView imgViewItem;
        TextView txtViewItem;

        public ImageViewHolder(@NonNull View itemView) {
            super(itemView);
            imgViewItem = itemView.findViewById(R.id.imgViewExtItem);
            txtViewItem = itemView.findViewById(R.id.txtViewExtItem);
            imgViewItem.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                   // itemView.setBackgroundColor(Color.LTGRAY);
                    onItemClickListener.onItemClick(getAdapterPosition());
                    SelectedInd = getAdapterPosition();
                    //when notifydatasetchanged is called,
                    // getAdapterPosition() goes back to -1
                    notifyDataSetChanged();
                }
            });
        }
    }
    public interface OnItemClickListener {
        public void onItemClick(int i);
    }

}
