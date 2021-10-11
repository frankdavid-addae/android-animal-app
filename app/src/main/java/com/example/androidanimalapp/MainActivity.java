package com.example.androidanimalapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements AnimalAdapter.AnimalClickInterface {

    ArrayList<Animal> animals;
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.rvAnimals);
        animals = new ArrayList<>();

        animals.add(new Animal("Dolphin", R.drawable.dolphin));
        animals.add(new Animal("Lion", R.drawable.lion));
        animals.add(new Animal("Owl", R.drawable.owl));
        animals.add(new Animal("Parrot", R.drawable.parrot));
        animals.add(new Animal("Rabbit", R.drawable.rabbit));
        animals.add(new Animal("Tiger", R.drawable.tiger));
        animals.add(new Animal("Turtle", R.drawable.turtle));
        animals.add(new Animal("Wolf", R.drawable.wolf));

        AnimalAdapter animalAdapter = new AnimalAdapter(animals, this, this);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(animalAdapter);
    }

    @Override
    public void onAnimalClick(int positionOfAnimal) {
        Toast.makeText(this, "Clicked " + animals.get(positionOfAnimal).getName(), Toast.LENGTH_SHORT).show();
    }
}