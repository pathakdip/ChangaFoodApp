package com.example.changafoodapp.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.changafoodapp.R;

public class Dashboard extends AppCompatActivity {

    CardView card1,card2,card3,card4,card5,card6;
    TextView txtCanteen1,txtCanteen2,txtCanteen3,txtCanteen4,txtCanteen5,txtCanteen6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.getSupportActionBar().hide();
        setContentView(R.layout.activity_dashboard);


        //initialising views
        card1=findViewById(R.id.card1);
        card2=findViewById(R.id.card2);
        card3=findViewById(R.id.card3);
        card4=findViewById(R.id.card4);
        card5=findViewById(R.id.card5);
        card6=findViewById(R.id.card6);
        txtCanteen1=findViewById(R.id.txtCanteen1);
        txtCanteen2=findViewById(R.id.txtCanteen2);
        txtCanteen3=findViewById(R.id.txtCanteen3);
        txtCanteen4=findViewById(R.id.txtCanteen4);
        txtCanteen5=findViewById(R.id.txtCanteen5);
        txtCanteen6=findViewById(R.id.txtCanteen6);


        //card view click actions
        card1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent=new Intent(Dashboard.this,FoodListActivity.class);
                intent.putExtra("canteen_name",txtCanteen1.getText().toString());
                startActivity(intent);
            }
        });

        card2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent=new Intent(Dashboard.this,FoodListActivity.class);
                intent.putExtra("canteen_name",txtCanteen2.getText().toString());
                startActivity(intent);
            }
        });

        card3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent=new Intent(Dashboard.this,FoodListActivity.class);
                intent.putExtra("canteen_name",txtCanteen3.getText().toString());
                startActivity(intent);
            }
        });


        card4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent=new Intent(Dashboard.this,FoodListActivity.class);
                intent.putExtra("canteen_name",txtCanteen4.getText().toString());
                startActivity(intent);
            }
        });

        card5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent=new Intent(Dashboard.this,FoodListActivity.class);
                intent.putExtra("canteen_name",txtCanteen5.getText().toString());
                startActivity(intent);
            }
        });

        card6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent=new Intent(Dashboard.this,FoodListActivity.class);
                intent.putExtra("canteen_name",txtCanteen6.getText().toString());
                startActivity(intent);
            }
        });

    }
}
