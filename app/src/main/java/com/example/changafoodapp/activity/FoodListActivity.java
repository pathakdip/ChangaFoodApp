package com.example.changafoodapp.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.SharedPreferences;
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


    //String imgUrl="https://www.seriouseats.com/recipes/images/2015/07/20150702-sous-vide-hamburger-anova-primary-1500x1125.jpg";
    int imgUrl=R.drawable.foodapp_logo;


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
        Log.e("FoodListActivity","name: "+fromDashboard);
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


        assert fromDashboard != null;
        switch (fromDashboard) {
            case "Iceberg":
                displayIcebergFoodData();

                break;
            case "Krishna\nJuice\nCorner":
                displayJiceCenterFoodData();

                break;
            case "Danny's":
                displayDannysFoodData();

                break;
            case "Shreeji\nCanteen":
                displayShreejiCanteenFoodData();

                break;
            case "Sweetspot":
                displaySeetspotFoodData();

                break;
            case "Krishna\nChaat\nCorner":
                displayChaatCenterFoodData();

                break;
        }

    }

    private void displayIcebergFoodData() {


        Food food= new Food("Mango Thick Shake","Rs 30",imgUrl);
        foodList.add(food);

        food= new Food("Kiwi Thick Shake","Rs 40",imgUrl);
        foodList.add(food);

        food= new Food("Raspberry Thick Shake","Rs 40",imgUrl);
        foodList.add(food);

        food= new Food("Garlic bread","Rs 100",imgUrl);
        foodList.add(food);

        food= new Food("Aloo Tikki Burger","Rs 30",imgUrl);
        foodList.add(food);

        food= new Food("Aloo Tikki Burger with Cheese","Rs 40",imgUrl);
        foodList.add(food);

        food= new Food("Veg Grilled Sandwich","Rs 45",imgUrl);
        foodList.add(food);

        food= new Food("Veg Cheese Grilled Sandwich","Rs 55",imgUrl);
        foodList.add(food);

        food= new Food("Bread Butter Grilled Sandwich","Rs 35",imgUrl);
        foodList.add(food);

        food= new Food("IB Red Grilled Sandwich","Rs 45",imgUrl);
        foodList.add(food);

        food= new Food("Cheese Grilled Sandwich","Rs 35",imgUrl);
        foodList.add(food);

        food= new Food("Heatwave Pizza","Rs 70",imgUrl);
        foodList.add(food);


        foodListAdapter.notifyDataSetChanged();
    }


    private void displayJiceCenterFoodData() {


        Food food= new Food("Apple Juice","Rs 40",imgUrl);
        foodList.add(food);

        food= new Food("Mango Juice","Rs 40",imgUrl);
        foodList.add(food);

        food= new Food("Pineapple Juice","Rs 40",imgUrl);
        foodList.add(food);

        food= new Food("Strawberry Juice","Rs 40",imgUrl);
        foodList.add(food);

        food= new Food("Kiwi Juice","Rs 40",imgUrl);
        foodList.add(food);

        food= new Food("Chocolate Juice","Rs 40",imgUrl);
        foodList.add(food);

        food= new Food("Orange Juice","Rs 40",imgUrl);
        foodList.add(food);



        foodListAdapter.notifyDataSetChanged();
    }

    private void displayChaatCenterFoodData() {


        Food food= new Food("Bombay Bhel","Rs 30",imgUrl);
        foodList.add(food);

        food= new Food("American Bhel","Rs 30",imgUrl);
        foodList.add(food);

        food= new Food("Cheese Masala","Rs 50",imgUrl);
        foodList.add(food);

        food= new Food("Pani Puri","Rs 20",imgUrl);
        foodList.add(food);

        food= new Food("Dhai Masala Puri","Rs 30",imgUrl);
        foodList.add(food);

        food= new Food("Basket Chaat","Rs 30",imgUrl);
        foodList.add(food);

        food= new Food("Delhi Chaat","Rs 30",imgUrl);
        foodList.add(food);

        food= new Food("Krishna Chaat Special","Rs 50",imgUrl);
        foodList.add(food);



        foodListAdapter.notifyDataSetChanged();
    }

    private void displayDannysFoodData() {


        Food food= new Food("7 Club cheese pizza","Rs 110",imgUrl);
        foodList.add(food);

        food= new Food("Cold Coffee","Rs 30",imgUrl);
        foodList.add(food);

        food= new Food("Cheese maggie masala","Rs 60",imgUrl);
        foodList.add(food);

        food= new Food("Club sandwich","Rs 130",imgUrl);
        foodList.add(food);

        food= new Food("French fries with mayonese","Rs 50",imgUrl);
        foodList.add(food);

        food= new Food("Hot chocolate","Rs 30",imgUrl);
        foodList.add(food);

        food= new Food("Italian pizzae","Rs 80",imgUrl);
        foodList.add(food);


        foodListAdapter.notifyDataSetChanged();
    }

    private void displayShreejiCanteenFoodData() {


        Food food= new Food("Fix thali","Rs 40",imgUrl);
        foodList.add(food);

        food= new Food("Masala Dosa","Rs 40",imgUrl);
        foodList.add(food);

        food= new Food("Manchurian","Rs 40",imgUrl);
        foodList.add(food);

        food= new Food("Manchurian Rice","Rs 60",imgUrl);
        foodList.add(food);

        food= new Food("Cheese potato","Rs 50",imgUrl);
        foodList.add(food);

        food= new Food("Uttapam","Rs 50",imgUrl);
        foodList.add(food);

        food= new Food("Masala Uttapam","Rs 60",imgUrl);
        foodList.add(food);

        food= new Food("Paneer Chilli","Rs 70",imgUrl);
        foodList.add(food);


        foodListAdapter.notifyDataSetChanged();
    }

    private void displaySeetspotFoodData() {


        Food food= new Food("Vanilla Icecream","Rs 40",imgUrl);
        foodList.add(food);

        food= new Food("Choco Chips","Rs 40",imgUrl);
        foodList.add(food);

        food= new Food("American Dry Fruit","Rs 60",imgUrl);
        foodList.add(food);

        food= new Food("Butter scotch","Rs 40",imgUrl);
        foodList.add(food);

        food= new Food("Kesar Pista","Rs 40",imgUrl);
        foodList.add(food);

        food= new Food("Chocolate Cone","Rs 30",imgUrl);
        foodList.add(food);

        food= new Food("Butter scotch cone","Rs 30",imgUrl);
        foodList.add(food);



        foodListAdapter.notifyDataSetChanged();
    }
}
