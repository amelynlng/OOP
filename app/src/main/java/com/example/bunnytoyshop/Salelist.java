package com.example.bunnytoyshop;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.database.Cursor;
import android.os.Bundle;
import android.widget.Toast;

import java.util.ArrayList;

public class Salelist extends AppCompatActivity {

    RecyclerView recyclerView;
    ArrayList<String> id, name, purchase, cost, date;
    DatabaseHelper DB;
    MyAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_salelist);

        DB = new DatabaseHelper(this);
        id = new ArrayList<>();
        name = new ArrayList<>();
        purchase = new ArrayList<>();
        cost = new ArrayList<>();
        date = new ArrayList<>();
        recyclerView = findViewById(R.id.list);
        adapter = new MyAdapter(this,id,name,purchase,cost,date);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        displaydata();

    }

    private void displaydata() {

        Cursor cursor = DB.getdata();
        if(cursor.getCount() == 0){
            Toast.makeText(Salelist.this,"No Entry Exists",Toast.LENGTH_SHORT).show();
            return;
        }
        else{
            while (cursor.moveToNext()){
                id.add(cursor.getString(0));
                name.add(cursor.getString(1));
                purchase.add(cursor.getString(2));
                cost.add(cursor.getString(3));
                date.add(cursor.getString(4));
            }
        }
    }


}