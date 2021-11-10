package com.example.homemanagementsystemapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainActivity extends AppCompatActivity {
EditText t1,t2,t3;
    String iN,iC,iDes;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        t1=findViewById(R.id.t1);
        t2=findViewById(R.id.t2);

        t3=findViewById(R.id.t3);

    }

    public void insertData(View view) {
       P1SQLiteDb p1SQLiteDb= new P1SQLiteDb(getApplicationContext());
        iN=t1.getText().toString();
        iC=t2.getText().toString();
        iDes=t3.getText().toString();
        if(iN.isEmpty()| iC.isEmpty()|iDes.isEmpty()){
            Toast.makeText(getApplicationContext(), "Please fill the details", Toast.LENGTH_SHORT).show();
        }
        else {

            String res = p1SQLiteDb.addDetails(iN, iC, iDes);
            Toast.makeText(getApplicationContext(), res, Toast.LENGTH_SHORT).show();
            t1.setText("");
            t2.setText("");
            t3.setText("");
            startActivity(new Intent(this, P1SQLiteDisplayDetails.class));
        }
    }


    // moving on Floating Action Button Activity
    public void goToFabBtn(View view) {

        startActivity( new Intent(MainActivity.this, P2FloatingActionButton.class));
    }
}