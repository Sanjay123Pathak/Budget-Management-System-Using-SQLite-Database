package com.example.homemanagementsystemapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import java.security.PublicKey;


public class P1SQLiteDb  extends SQLiteOpenHelper {
    private  static final String DbName="BudgetManagementSystem.db";
    private  Context context;
    // FOR CREATING TABLE

    // FOR DROPPING TABLE

    public P1SQLiteDb(Context context) {
        super(context, DbName, null,1);
        this.context=context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String tableNameQuery="create table BudgetManagementSys (id integer primary key autoincrement,itemName text,itemCost text,itemDesc text)";
        db.execSQL(tableNameQuery);


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS BudgetManagementSys");
        onCreate(db);
    }

    public  String addDetails(String iName,String iCost,String iDesc){
        SQLiteDatabase sqlDb= this.getWritableDatabase();
        ContentValues contentValues= new ContentValues();
        contentValues.put("itemName",iName);
        contentValues.put("itemCost",iCost);
        contentValues.put("itemDesc",iDesc);
       long res= sqlDb.insert("BudgetManagementSys",null,contentValues);//it returns values
        sqlDb.close();
        if (res== -1){
            return "Failed to insert Data";
        }
        else
            return "SuccessFully Inserted";
    }

    public  int deleteDetails(String itemName){
        SQLiteDatabase db= this.getWritableDatabase();
         return  db.delete("BudgetManagementSys","itemName= ?",new String[]{itemName});
    }
    public  int updateDetail(SQLiteModalClass sm){
        SQLiteDatabase db= this.getWritableDatabase();
        ContentValues contentValues= new ContentValues();
        contentValues.put("itemName",sm.getItemName());
        contentValues.put("itemCost",sm.getItemCost());
        contentValues.put("itemDesc",sm.getItemDesc());
       return db.update("BudgetManagementSys",contentValues,"itemName= ?",new String[]{String.valueOf(sm.getItemName())});


    }
    public Cursor getAllData(){
        SQLiteDatabase db= this.getWritableDatabase();
        String query1="Select * from BudgetManagementSys order by id desc";
        Cursor cr= db.rawQuery(query1,null);
        return  cr;
    }
}
