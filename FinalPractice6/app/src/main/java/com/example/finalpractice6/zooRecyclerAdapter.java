package com.example.finalpractice6;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.finalpractice6.databinding.LayoutRecyclerviewBinding;

import java.util.List;

public class zooRecyclerAdapter extends RecyclerView.Adapter<zooRecyclerAdapter.zooHolder>{
    public OnClickListener onClickListener;
    public List<person> personList;

    public void setPersonList(List<person> personList) {
        this.personList = personList;
        notifyDataSetChanged();
    }

    public zooRecyclerAdapter(List<person> personList, OnClickListener onClickListener) {
        this.onClickListener = onClickListener;
        this.personList = personList;
    }

    @NonNull
    @Override
    public zooHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutRecyclerviewBinding binding = LayoutRecyclerviewBinding.inflate(LayoutInflater.from(parent.getContext()),parent,false);
        zooHolder holder = new zooHolder(binding.getRoot(),binding);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull zooHolder holder, int position) {
        holder.binding.textViewName.setText(personList.get(position).name);
        holder.binding.txtFavoriteAnimal.setText(personList.get(position).favoriteAnimal);
    }

    @Override
    public int getItemCount() {
        return personList.size();
    }

    public class zooHolder extends RecyclerView.ViewHolder {
        LayoutRecyclerviewBinding binding;
        public zooHolder(@NonNull View itemView) {
            super(itemView);
        }

        public zooHolder(@NonNull View itemView, LayoutRecyclerviewBinding binding) {
            super(itemView);
            this.binding = binding;
            this.binding.getRoot().setOnClickListener(view -> {
                onClickListener.onItemClick(getAdapterPosition());
            });
        }
    }
    public interface OnClickListener {
        public void onItemClick(int i);
    }
}
