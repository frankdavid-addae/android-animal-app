package com.example.androidanimalapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class AnimalInfoActivity extends AppCompatActivity {

    ImageView imgAnimalInfoImage;
    TextView txtAnimalInfoName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animal_info);

        imgAnimalInfoImage = findViewById(R.id.imgAnimalInfoImage);
        txtAnimalInfoName = findViewById(R.id.txtAnimalInfoName);

        Intent intent = getIntent();

        imgAnimalInfoImage.setImageResource(intent.getIntExtra("animalImage", R.drawable.animal_image_placeholder));
        txtAnimalInfoName.setText(intent.getStringExtra("animalName"));
    }
}