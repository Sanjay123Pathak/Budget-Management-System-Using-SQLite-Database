package com.example.homemanagementsystemapp;

import androidx.appcompat.app.AppCompatActivity;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class P1SQLUpdate extends AppCompatActivity {
EditText e1,e2,e3;
String idRef;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // for getting data from adapter class
        SQLiteModalClass liteModalClass= (SQLiteModalClass) getIntent().getExtras().getSerializable("SQLiteModalClass");
        setContentView(R.layout.activity_p1_sqlupdate);
        e1=findViewById(R.id.e1);
        e2=findViewById(R.id.e2);
        e3=findViewById(R.id.e3);


        e1.setText(liteModalClass.getItemName());
        e2.setText(liteModalClass.getItemCost());
        e3.setText(liteModalClass.getItemDesc());
        // for getting references
          idRef=liteModalClass.getItemName();

    }

    public void UpdateData(View view) {
        String iName,iCost,iDesc;
        iName=e1.getText().toString();
        iCost=e2.getText().toString();
        iDesc=e3.getText().toString();
        SQLiteModalClass sl= new SQLiteModalClass(idRef,iCost,iDesc);
        P1SQLiteDb p1db= new P1SQLiteDb(getApplicationContext());
        int res=p1db.updateDetail(sl);
        if (res>=0){
            Toast.makeText(this, "Data Updated Successfully", Toast.LENGTH_SHORT).show();
            finish();
        }
        else {
            Toast.makeText(this, "Not Updated ", Toast.LENGTH_SHORT).show();
        }
    }
}