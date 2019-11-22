package com.example.changafoodapp.adapter;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.changafoodapp.activity.AddToCartActivity;
import com.example.changafoodapp.model.Food;
import com.example.changafoodapp.R;

import java.util.List;

public class FoodListAdapter extends RecyclerView.Adapter<FoodListAdapter.MyViewHolder> {

    private List<Food> foodList;
    Context context;
    int url;

    public static final String MyPREFERENCES = "MyPrefs" ;
    SharedPreferences sharedpreferences;

    public FoodListAdapter(Context context,List<Food> foodList1,int url) {
        this.context=context;
        this.foodList = foodList1;
        this.url=url;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.food_list_row, parent, false);
        MyViewHolder viewHolder=new MyViewHolder(itemView);

        sharedpreferences = context.getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        final Food foodItem = foodList.get(position);
        holder.foodTitle.setText(foodItem.getTitle());

        holder.foodPrice.setText(foodItem.getPrice());

        Log.e("FoodApater","item: "+foodItem.getTitle());

        Glide.with(context).load(url).into(holder.imageView);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context,"you have selected "+foodItem.getTitle(),Toast.LENGTH_LONG).show();
            }
        });

        holder.imgAddtoCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                SharedPreferences.Editor editor = sharedpreferences.edit();
                editor.putString("product_name", foodItem.getTitle());
                editor.putString("product_price", foodItem.getPrice());
                editor.commit();
                editor.apply();

                Toast.makeText(context, "Item Added to cart", Toast.LENGTH_SHORT).show();
                Intent intent=new Intent(context, AddToCartActivity.class);
                intent.putExtra("product_name",foodItem.getTitle());
                intent.putExtra("product_price",foodItem.getPrice());
                context.startActivity(intent);
            }
        });



    }

    @Override
    public int getItemCount() {

        return foodList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView foodTitle,foodPrice;
        ImageView imageView,imgAddtoCart;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            foodTitle=itemView.findViewById(R.id.txtFoodTitle);
            foodPrice=itemView.findViewById(R.id.txtFoodItemPrice);
            imageView=itemView.findViewById(R.id.imgFoodItem);
            imgAddtoCart=itemView.findViewById(R.id.imgAddtoCart);
        }
    }
}
