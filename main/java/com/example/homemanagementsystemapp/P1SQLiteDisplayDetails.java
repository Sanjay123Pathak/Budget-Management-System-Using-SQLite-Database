package com.example.homemanagementsystemapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.database.Cursor;
import android.os.Bundle;


import java.util.ArrayList;

public class P1SQLiteDisplayDetails extends AppCompatActivity {
RecyclerView recyclerView;
LinearLayoutManager lm;
ArrayList<SQLiteModalClass> arrayList;
SQLiteAdapter adapter;
Cursor cursor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_p1_sqlite_display_details);
        recyclerView=findViewById(R.id.r1);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
          arrayList= new ArrayList<>();
         cursor= new P1SQLiteDb(getApplicationContext()).getAllData();
         while (cursor.moveToNext()){
              SQLiteModalClass modalClass= new SQLiteModalClass(cursor.getString(1),"Rs "+cursor.getString(2),cursor.getString(3));
              arrayList.add( modalClass);
         }
         adapter= new SQLiteAdapter(getApplicationContext(),arrayList);
         recyclerView.setAdapter(adapter);

         //
//        recyclerView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//            }
//        });
    }
}