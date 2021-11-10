package com.example.homemanagementsystemapp;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class SQLiteAdapter extends RecyclerView.Adapter<SQLiteAdapter.SQliteViewholder> {

 Context context;
    ArrayList<SQLiteModalClass> arrayList;
    P1SQLiteDb p1SQLiteDb;

    public SQLiteAdapter(Context context, ArrayList<SQLiteModalClass> arrayList) {
        this.context = context;
        this.arrayList = arrayList;
    }

    @Override
    public SQliteViewholder onCreateViewHolder( ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.p1_sqlitel_ayout, parent,
                false);
        return new SQliteViewholder(view);
    }

    @Override
    public void onBindViewHolder( SQliteViewholder holder, int position) {
        final SQLiteModalClass sModal=arrayList.get(position);
    holder.textView1.setText(sModal.getItemName());
    holder.textView2.setText( sModal.getItemCost());
    holder.textView3.setText(sModal.getItemDesc());

// click listener for the deleting the records
    holder.cardView.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            // for alert Dialog
         AlertDialog.Builder  ab= new AlertDialog.Builder(v.getRootView().getContext());
         // for setting tittle and message
         ab.setTitle("Confirmation !!!");
         ab.setMessage("What You Want To Do  ? ");
         ab.setIcon(R.drawable.ic_baseline_delete_24);
         ab.setPositiveButton("Delete", new DialogInterface.OnClickListener() {
             @Override
             public void onClick(DialogInterface dialog, int which) {
                 p1SQLiteDb= new P1SQLiteDb(context);
                // for deleting the row
                 int deleteRow=p1SQLiteDb.deleteDetails(sModal.getItemName());
                 if (deleteRow>=0){
                     Toast.makeText(context, "Data deleted Successfully", Toast.LENGTH_SHORT).show();
                     arrayList.remove(sModal);
                     notifyDataSetChanged();// refreshing the database
                 }
                 else {
                     Toast.makeText(context, "Not Deleted ", Toast.LENGTH_SHORT).show();
                 }
             }
         });
         ab.setNegativeButton("Update", new DialogInterface.OnClickListener() {
             @Override
             public void onClick(DialogInterface dialog, int which) {
                 Toast.makeText(context, "No clicked", Toast.LENGTH_SHORT).show();
                  Intent intent= new Intent(context,P1SQLUpdate.class);
                  intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                  intent.putExtra("SQLiteModalClass",sModal);
                  context.startActivity(intent);
                 dialog.dismiss();


             }
         });
         ab.setCancelable(false);
         // showing the dialog box
         AlertDialog alertDialog= ab.create();
         alertDialog.show();

        }
    });
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public  class SQliteViewholder extends RecyclerView.ViewHolder{
       TextView textView1,textView2,textView3;
       CardView cardView;
        public SQliteViewholder( View itemView) {
            super(itemView);
            textView1=itemView.findViewById(R.id.textView1);
            textView2=itemView.findViewById(R.id.textView2);
            textView3=itemView.findViewById(R.id.textView3);
            cardView=itemView.findViewById(R.id.card1);


        }
    }
}
