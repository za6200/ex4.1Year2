package com.example.ex32year2;

import static java.lang.Math.pow;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class SerieActivity2 extends AppCompatActivity implements AdapterView.OnItemClickListener, View.OnLongClickListener, AdapterView.OnItemLongClickListener, View.OnCreateContextMenuListener {
    /**
     * @author		ziv ankri za6200@bs.amalnet.k12.il
     * @version     7.3.1
     * @since       27/9/2023
     * class will make the serie with the intent givven in last activity and use it to make the serie
     * and make menu to for the position and sum
     */
    ListView listSerie1;
    Intent serie2;
    TextView n;
    Double numbers[];
    int position1 = 0;
    Intent Albert;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_serie1);
        serie2 = getIntent();
        listSerie1 = findViewById(R.id.list_serie);
        n = findViewById(R.id.n);
        numbers = new Double[20];
        numbers[0] = serie2.getDoubleExtra("first_num", 0);
        Albert = new Intent(this, credits.class);
        for (int i = 1; i < 20; i++) {
            if (serie2.getBooleanExtra("choice", false)) {
                numbers[i] = serie2.getDoubleExtra("first_num", 0) * pow(serie2.getDoubleExtra("progressor", 0), i);
            } else {
                numbers[i] = serie2.getDoubleExtra("first_num", 0) + i * serie2.getDoubleExtra("progressor", 0);

            }
        }

        ArrayAdapter<Double> adp = new ArrayAdapter<Double>(this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item, numbers);
        listSerie1.setAdapter(adp);
        listSerie1.setOnItemLongClickListener(this);
        listSerie1.setOnCreateContextMenuListener(this);
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

    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        /**
         * function will make the manu items
         */
        menu.setHeaderTitle("menu1");
        menu.add("position");
        menu.add("sum");


    }
    @Override
    public boolean onContextItemSelected(MenuItem item) {
        /**
         * function will get the item selected and use it for the text view
         */
        if(item.getTitle().equals("position"))
        {
            n.setText("" + position1);
        }
        else
        {
            double sum = 0;
            for (int i = 0; i <= position1 - 1; i++) {
                sum += numbers[i];
            }
            n.setText("" + sum);
        }
        return true;
    }
    @Override
    public boolean onLongClick(View v) {

        return false;
    }

    @Override
    public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
        position1 = position + 1;
        return false;
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

    }
}
