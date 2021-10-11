package com.example.androidanimalapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class AnimalAdapter extends RecyclerView.Adapter<AnimalAdapter.AnimalRowHolder> {

    ArrayList<Animal> animalData;
    Context context;
    AnimalClickInterface animalClickInterface;

    public AnimalAdapter(ArrayList<Animal> animalData, Context context, AnimalClickInterface animalClickInterface) {
        this.animalData = animalData;
        this.context = context;
        this.animalClickInterface = animalClickInterface;
    }

    @NonNull
    @Override
    public AnimalRowHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.animal_row, parent, false);
        return new AnimalRowHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AnimalRowHolder holder, int position) {
        holder.txtAnimalName.setText(animalData.get(position).getName());
        holder.imgAnimalImage.setImageResource(animalData.get(position).getImage());
    }

    @Override
    public int getItemCount() {
        return animalData.size();
    }

    class AnimalRowHolder extends RecyclerView.ViewHolder {

        TextView txtAnimalName;
        ImageView imgAnimalImage;

        public AnimalRowHolder(@NonNull View itemView) {
            super(itemView);

            txtAnimalName = itemView.findViewById(R.id.txtAnimalName);
            imgAnimalImage = itemView.findViewById(R.id.imgAnimalImage);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    animalClickInterface.onAnimalClick(getAdapterPosition());
                }
            });
        }
    }

    interface AnimalClickInterface {
        void onAnimalClick(int positionOfAnimal);
    }
}
