package com.example.ex32year2;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.TextView;

public class credits extends AppCompatActivity {
    /**
     * class will give the credit to Albert Levi
     */
    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_credits);
        textView = findViewById(R.id.textView2);
        textView.setText("credit to Albert Levi");
    }
}