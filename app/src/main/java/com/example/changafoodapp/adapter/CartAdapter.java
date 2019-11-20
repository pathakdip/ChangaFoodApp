package com.example.changafoodapp.adapter;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.changafoodapp.R;
import com.example.changafoodapp.activity.AddToCartActivity;
import com.example.changafoodapp.activity.Dashboard;
import com.example.changafoodapp.model.Food;

import java.util.ArrayList;

public class CartAdapter extends RecyclerView.Adapter<CartAdapter.ViewHolder> {

    ArrayList<String> foods=new ArrayList<>();
    String p_name,price;
    Context context;

    public CartAdapter(Context context, ArrayList<String> foodList, String name,String price) {
        this.context=context;
        this.foods=foodList;
        this.p_name=name;
        this.price=price;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.cart_row,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, int position) {

        //final Food foodItem = foods.get(position);
        Log.e("CartAdapter","item name: "+p_name);

        holder.txtProductname.setText(p_name);
        holder.txtProductprice.setText(price);

        holder.btnReduceItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String str=holder.txtProductCount.getText().toString().trim();
                int parsedInt= Integer.parseInt(str);
                if(parsedInt == 1)
                {
                    holder.btnReduceItem.setEnabled(false);
                }
                else
                {
                    holder.btnReduceItem.setEnabled(true);
                    holder.txtProductCount.setText(String.valueOf(parsedInt-1));

                }
            }
        });

        holder.btnAddItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String str=holder.txtProductCount.getText().toString().trim();
                int parsedInt= Integer.parseInt(str);
                holder.btnReduceItem.setEnabled(true);
                holder.txtProductCount.setText(String.valueOf(parsedInt+1));

            }
        });

        holder.btnRemoveItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context,"Item Removed",Toast.LENGTH_LONG).show();
                Log.e("CartAdapter","item removed");
                context.startActivity(new Intent(context, Dashboard.class));
            }
        });
    }

    @Override
    public int getItemCount() {
        Log.e("CartAdapter","list size: "+foods.size());
        return foods.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView txtProductname,txtProductprice,txtProductCount,txtProductTotalPrice;
        Button btnReduceItem,btnAddItem,btnRemoveItem;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            txtProductname=itemView.findViewById(R.id.txtProductName);
            txtProductprice=itemView.findViewById(R.id.txtProductPrice);
            txtProductTotalPrice=itemView.findViewById(R.id.txtTotalPrice);
            txtProductCount=itemView.findViewById(R.id.txtProductCount);
            btnAddItem=itemView.findViewById(R.id.btnAddProduct);
            btnReduceItem=itemView.findViewById(R.id.btnReduceProduct);
            btnRemoveItem=itemView.findViewById(R.id.btnRemoveItem);

        }
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }


}
