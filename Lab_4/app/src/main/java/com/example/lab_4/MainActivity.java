package com.example.lab_4;


import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class MainActivity extends AppCompatActivity {

    Cat cat = new Cat();
    private TextView text1;
    private View view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        text1 = findViewById(R.id.textView1);
        view = findViewById(R.id.view);

        cat.name = "Мурзик";
        cat.age = 9;
        cat.color = Color.GRAY;

        GsonBuilder builder = new GsonBuilder();
        Gson gson = builder.create();

        String string = gson.toJson(cat);
        text1.setText(gson.toJson(cat));
        Cat murzik = gson.fromJson(string,Cat.class);
        text1.setText("Кот: "+murzik.name+", Цвет: "+murzik.color+", Возраст: "+murzik.age);
        view.setBackgroundColor(murzik.color);
    }
}