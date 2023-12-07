package com.example.finalproject5;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.finalproject5.databinding.LayoutPersonManagerBinding;
import com.google.android.material.transition.Hold;

import java.util.List;

public class RecyclerViewAdapter  extends RecyclerView.Adapter<RecyclerViewAdapter.personHolder>{
    List<Person> personList;
    onItemClickListner onItemClickListner;

    public RecyclerViewAdapter(List<Person> personList, RecyclerViewAdapter.onItemClickListner onItemClickListner) {
        this.personList = personList;
        this.onItemClickListner = onItemClickListner;
    }

    public List<Person> getPersonList() {
        return personList;
    }

    public void setPersonList(List<Person> personList) {
        this.personList = personList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public personHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutPersonManagerBinding binding = LayoutPersonManagerBinding.inflate(LayoutInflater.from(parent.getContext()),parent,false);
        personHolder Holder = new personHolder(binding.getRoot(),binding);
        return Holder;
    }

    @Override
    public void onBindViewHolder(@NonNull personHolder holder, int position) {
        holder.binding.textViewName.setText(personList.get(position).personName);
        holder.binding.textView3.setText(personList.get(position).personDob);
        holder.binding.txtFavoriteAnimal.setText(personList.get(position).getAnimalId());
    }

    @Override
    public int getItemCount() {
        return personList.size();
    }

    public  class personHolder extends RecyclerView.ViewHolder {
        LayoutPersonManagerBinding binding;
        public personHolder(@NonNull View itemView) {
            super(itemView);
        }

        public personHolder(@NonNull View itemView, LayoutPersonManagerBinding binding) {
            super(itemView);
            this.binding = binding;
            this.binding.getRoot().setOnClickListener(view-> {
                onItemClickListner.onItemClick(getAdapterPosition());
            });
        }

    }
    public interface onItemClickListner {
        public void onItemClick(int i );
    }
}
