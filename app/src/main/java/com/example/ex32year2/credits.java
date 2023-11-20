package com.example.ex32year2;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class credits extends AppCompatActivity {
    /**
     * @author		ziv ankri adress: za6200@bs.amalnet.k12.il
     * @version	    7.3.1
     * @since       27/9/2023
     * class will give the credit to Albert Levi
     */
    TextView textView;
    Intent backActivity;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_credits);
        textView = findViewById(R.id.textView2);
        textView.setText("credit to Albert Levi");
        backActivity = new Intent(this, MainActivity.class);
    }

    public void back(View view) {
        startActivity(backActivity);
    }
}