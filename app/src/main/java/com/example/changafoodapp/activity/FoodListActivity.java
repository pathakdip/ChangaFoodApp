package com.example.changafoodapp.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.changafoodapp.adapter.FoodListAdapter;
import com.example.changafoodapp.model.Food;
import com.example.changafoodapp.R;

import java.util.ArrayList;
import java.util.List;

public class FoodListActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    RecyclerView.LayoutManager mLayoutManager;
    FoodListAdapter foodListAdapter;
    private List<Food> foodList = new ArrayList<>();

    ImageView imgBack;
    TextView txtCanteenTitle;

    String imgUrl="https://encrypted-tbn0.gstatic.com/images?q=tbn%3AANd9GcQbu-YmXRdn0eaPm18CXI-7lHw8DhwwoEL1GtaJDor0Yt-uHIlp";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.getSupportActionBar().hide();
        setContentView(R.layout.activity_food_list);

        //initialising views
        recyclerView=findViewById(R.id.recyclerview);
        imgBack=findViewById(R.id.imgBack);
        txtCanteenTitle=findViewById(R.id.txtCanteenTitle);

        //setting title for screen
        String fromDashboard=getIntent().getStringExtra("canteen_name");
        txtCanteenTitle.setText(fromDashboard);

        //move to Previous screen
        imgBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });


        //displaying list in recycler view
        foodListAdapter = new FoodListAdapter(this,foodList,imgUrl);
        mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(foodListAdapter);

        displayFoodData();


    }

    private void displayFoodData() {


        Food food= new Food("Dragon Noodles with Dumplings",imgUrl);
        foodList.add(food);

        food= new Food("DThai Stir-Fry Chicken",imgUrl);
        foodList.add(food);

        food= new Food("Pan-Asian Egg 'n' Chicken Chowmein",imgUrl);
        foodList.add(food);

        food= new Food("Nizami Chicken Biriyani",imgUrl);
        foodList.add(food);

        food= new Food("Sholay Masala Biriyani",imgUrl);
        foodList.add(food);

        food= new Food("Murgh Dum Biriyani",imgUrl);
        foodList.add(food);

        food= new Food("Ghee-Roast Chicken Biriyani",imgUrl);
        foodList.add(food);

        food= new Food("Mutter Paneer Dum Biriyani",imgUrl);
        foodList.add(food);

        food= new Food("Mutter Paneer Dum Biriyani",imgUrl);
        foodList.add(food);

        food= new Food("Cilantro Asian Chicken Bowl",imgUrl);
        foodList.add(food);

        food= new Food("Thai Stir-Fry Chicken",imgUrl);
        foodList.add(food);

        food= new Food("Black Pepper Honey Chicken 'n' Noodles",imgUrl);
        foodList.add(food);


        foodListAdapter.notifyDataSetChanged();
    }
}
