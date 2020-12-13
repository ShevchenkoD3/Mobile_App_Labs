package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Phraser phraser = new Phraser();
    private TextView text1;
    private TextView text2;
    private Button button1;
    private String string;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        text1 = findViewById(R.id.text1);
        text2 = findViewById(R.id.text2);
        button1 = findViewById(R.id.button);
        string = phraser.PhraserGen();
        text1.setText("Всё, что нам нужно – это "+string);
        text2.setText(string.substring(0, 1).toUpperCase() + string.substring(1)+" - это всё, что нам нужно");

        View.OnClickListener gen = new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                string = phraser.PhraserGen();
                text1.setText("Всё, что нам нужно – это "+string);
                text2.setText(string.substring(0, 1).toUpperCase() + string.substring(1)+" - это всё, что нам нужно");
            }
        };
        button1.setOnClickListener(gen);
    }
}