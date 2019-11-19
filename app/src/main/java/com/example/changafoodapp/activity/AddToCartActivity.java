package com.example.changafoodapp.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.text.method.CharacterPickerDialog;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.changafoodapp.R;
import com.example.changafoodapp.adapter.CartAdapter;
import com.example.changafoodapp.model.Food;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.logging.Level;

public class AddToCartActivity extends AppCompatActivity {

    ImageView imgBack;
    Button btnPlaceOrder,btnContinueOrder;
    RecyclerView recyclerView;
    CartAdapter adapter;
    ArrayList<Food> foodList=new ArrayList<>();
    ArrayList<String> foodLists=new ArrayList<>();
    private DatabaseReference rootRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.getSupportActionBar().hide();
        setContentView(R.layout.activity_add_to_cart);

        //initialising views
        imgBack=findViewById(R.id.imgBack);
        btnPlaceOrder=findViewById(R.id.btnPlaceOrder);
        btnContinueOrder=findViewById(R.id.btnContinueOrder);

        String name=getIntent().getStringExtra("product_name");
        Log.e("AddToCart","product name: "+name);
        String price=getIntent().getStringExtra("product_price");
        foodLists.add(price);
        foodLists.add(name);

        //adding item to database
        rootRef = FirebaseDatabase.getInstance().getReference().child("foodItems");
        for(String foods : foodLists) {
            rootRef.child("foodItems").child(foods).setValue(true);
        }

        //String currentUserID= FirebaseAuth.getInstance().getCurrentUser().getUid();
        rootRef.child("interests").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for(DataSnapshot postSnapshot : dataSnapshot.getChildren()){
                    boolean isInterested = (Boolean)postSnapshot.getValue();
                    if (isInterested){
                        foodLists.add(postSnapshot.getKey());
                    }
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });



        //displaying list of product in cart
        recyclerView=findViewById(R.id.cartRecyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter=new CartAdapter(AddToCartActivity.this,foodLists,name,price);
        recyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();

        //moving to previous screen
        imgBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        //button actions
        btnPlaceOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(AddToCartActivity.this,"Place Order",Toast.LENGTH_LONG).show();
            }
        });

        btnContinueOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(AddToCartActivity.this,Dashboard.class));
            }
        });
    }
}
