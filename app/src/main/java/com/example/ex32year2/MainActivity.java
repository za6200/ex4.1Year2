package com.example.ex32year2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnCreateContextMenuListener{
    /**
     * @author		ziv ankri address: za6200@bs.amalnet.k12.il
     * @version	    7.3.1
     * @since       27/9/2023
     * class will get the first num and the progress and send in to the next
     * activity by intent
     */

    Switch switch1;
    EditText firstNum;
    EditText mulOrPlus;
    Intent si;
    Intent Albert;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        switch1 = findViewById(R.id.choice1);
        firstNum = findViewById(R.id.first_num);
        mulOrPlus = findViewById(R.id.mulOrPlus);
        si = new Intent(this, SerieActivity2.class);
        Albert = new Intent(this, credits.class);

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.main,menu);

        return super.onCreateOptionsMenu(menu);
    }
    public boolean onOptionsItemSelected(@NonNull MenuItem item){
        /**
         * function will see if credit selected and go to credit activity
         */
        String st = item.getTitle().toString();
        if(st.equals(("credit")))
        {
            startActivity(Albert);
        }
        return super.onOptionsItemSelected(item);

    }



    public void clicked(View view) {
        /**
         * if the switch clicked change the name
         */
        if (switch1.isChecked()) {
            switch1.setText("Geometric");
        } else {
            switch1.setText("Math");
        }
    }

    public void next_activity(View view) {
        /**
         * check the input and go to the next activity by pressing the button NEXT
         */
        si.putExtra("choice", switch1.isChecked());
        String check = "";
        String check2 = "";
        int flag = 0;
        check = firstNum.getText().toString();
        check2 = mulOrPlus.getText().toString();
        if (check.equals(".") || check.equals("-") || check.equals("-.") || check.equals(".-") || check2.equals(".") || check2.equals("-") || check2.equals("-.") || check2.equals(".-")) {
            Toast.makeText(getApplicationContext(), "illegal input", Toast.LENGTH_SHORT).show();
            flag = 1;
        }
        if (check.length() == 0) {
            Toast.makeText(getApplicationContext(), "must enter the first num", Toast.LENGTH_SHORT).show();
            flag = 1;
        } else {
            si.putExtra("first_num", Double.parseDouble(check));

        }
        if (check2.length() == 0) {
            Toast.makeText(getApplicationContext(), "must enter progressor", Toast.LENGTH_SHORT).show();
            flag = 1;
        } else {
            si.putExtra("progressor", Double.parseDouble(check2));
        }

        if (flag == 0) {
            startActivity(si);

        }


    }
}