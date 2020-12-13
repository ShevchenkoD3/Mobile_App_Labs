package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.List;

public class DetailActivity extends AppCompatActivity {

    private TextView details;
    private DummyContent dummyContent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        dummyContent = new DummyContent();
        details = findViewById(R.id.details);

        Intent intent = getIntent();
        String data = intent.getStringExtra("id");



        details.setText(dummyContent.ITEMS.get(Integer.parseInt(data)-1).details);
    }
}