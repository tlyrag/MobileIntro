package com.example.finalpractice2.Adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.finalpractice2.Models.Animals;
import com.example.finalpractice2.databinding.LayoutGalleryitemBinding;

import java.util.List;

public class AnimalAdapter  extends RecyclerView.Adapter<AnimalAdapter.AnimalHolder>{
    List<Animals> animalsList;
    int adapterPosition;
    OnItemClickListener onItemClickListener;

    public AnimalAdapter(List<Animals> animalsList, OnItemClickListener onItemClickListener) {
        this.animalsList = animalsList;
        this.onItemClickListener = onItemClickListener;
    }

    public List<Animals> getAnimalsList() {
        return animalsList;
    }

    public void setAnimalsList(List<Animals> animalsList) {
        this.animalsList = animalsList;
    }

    public int getAdapterPosition() {
        return adapterPosition;
    }

    public void setAdapterPosition(int adapterPosition) {
        this.adapterPosition = adapterPosition;
        notifyDataSetChanged();
    }

    public OnItemClickListener getOnItemClickListener() {
        return onItemClickListener;
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    @NonNull
    @Override
    public AnimalHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutGalleryitemBinding binding = LayoutGalleryitemBinding.inflate(LayoutInflater.from(parent.getContext()),parent,false);
        AnimalHolder holder = new AnimalHolder(binding.getRoot(),binding);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull AnimalHolder holder, int position) {
        holder.binding.txtViewExtItem.setText(animalsList.get(position).getName());
        holder.binding.imgViewExtItem.setImageResource(animalsList.get(position).getAnimalPicture());

    }

    @Override
    public int getItemCount() {
        return animalsList.size();
    }

    public class AnimalHolder extends RecyclerView.ViewHolder {
        LayoutGalleryitemBinding binding;
        public AnimalHolder(@NonNull View itemView) {
            super(itemView);
        }
        public AnimalHolder(@NonNull View itemView, LayoutGalleryitemBinding binding) {
            super(itemView);
            this.binding = binding;
            this.binding.getRoot().setOnClickListener(view -> {
                onItemClickListener.onItemClick(getAdapterPosition());
            });
        }

    }
    public interface OnItemClickListener {
        public void onItemClick(int i);

    }
}
