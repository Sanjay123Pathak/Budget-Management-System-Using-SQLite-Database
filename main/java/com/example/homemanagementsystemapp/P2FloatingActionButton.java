package com.example.homemanagementsystemapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class P2FloatingActionButton extends AppCompatActivity {
FloatingActionButton fab;
LinearLayout ll2;
TextView tv1;
ImageView img1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_p2_floating_action_button);
        fab=findViewById(R.id.fab);
        ll2=findViewById(R.id.ll2);
        tv1=findViewById(R.id.tv1);
        img1=findViewById(R.id.image1);
        img1.setVisibility(View.INVISIBLE);
    }

    public void doWhatYouWant(View view) {
        //Creating the instance of PopupMenu
        PopupMenu popup = new PopupMenu(this, fab);
        //Inflating the Popup using xml file
        popup.getMenuInflater().inflate(R.menu.p2menu, popup.getMenu());

        //registering popup with OnMenuItemClickListener
        popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            public boolean onMenuItemClick(MenuItem item) {
                Toast.makeText(getApplicationContext(),"You Clicked : " + item.getTitle(), Toast.LENGTH_SHORT).show();
                switch (item.getItemId()){
                    case R.id.p1:
                        ll2.setBackgroundColor(Color.GREEN);
                        tv1.setTextColor(Color.WHITE);
                        tv1.setText("Background ,text and textColor are changed");


                        break;

                    case R.id.p2:
                          startActivity( new Intent(P2FloatingActionButton.this,MainActivity.class));

                        break;

                    case R.id.p3:

                        Toast.makeText(getApplicationContext(),"You Clicked : " + item.getTitle(), Toast.LENGTH_SHORT).show();
                        break;

                    case R.id.p4:

                        int night_mode= AppCompatDelegate.getDefaultNightMode();

                        if (night_mode==AppCompatDelegate.MODE_NIGHT_YES){
                            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);

                        }
                        else{
                            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);

                            recreate();
                        }

                        break;

                    case R.id.p5:
                         if(img1.VISIBLE==0){
                             img1.setVisibility(View.VISIBLE);
                         }else
                             img1.setVisibility(View.INVISIBLE);
                        break;
                }
                return true;
            }
        });

        popup.show();//showing popup menu
    }
}