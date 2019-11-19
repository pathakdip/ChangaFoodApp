package com.example.changafoodapp.adapter;

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
import com.example.changafoodapp.model.Food;

import java.util.ArrayList;

public class CartAdapter extends RecyclerView.Adapter<CartAdapter.ViewHolder> {

    ArrayList<Food> foods=new ArrayList<>();
    String p_name;

    public CartAdapter(ArrayList<Food> foodList,String name) {
        this.foods=foodList;
        this.p_name=name;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.cart_row,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, int position) {


        final Food foodItem = foods.get(position);
        
        holder.txtProductname.setText(p_name);


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

                    //calculating total amount of item
                    String amt=holder.txtProductprice.getText().toString().trim();
                    int parsedAmt=Integer.parseInt(amt);
                    int total_amt=parsedAmt*parsedInt;

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

                String amt=holder.txtProductprice.getText().toString().trim();
                int parsedAmt=Integer.parseInt(amt);
                int total_amt=parsedAmt*parsedInt;
            }
        });

        holder.btnRemoveItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.e("CartAdapter","item removed");
            }
        });
    }

    @Override
    public int getItemCount() {
        return foods.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView txtProductname,txtProductprice,txtProductCount;
        Button btnReduceItem,btnAddItem,btnRemoveItem;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            txtProductname=itemView.findViewById(R.id.txtProductName);
            txtProductprice=itemView.findViewById(R.id.txtProductPrice);
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


    // Insert a new item to the RecyclerView on a predefined position
    public void insert(int position, Food data) {
        foods.add(position, data);
        notifyItemInserted(position);
    }

    // Remove a RecyclerView item containing a specified Data object
    public void remove(Food data) {
        int position = foods.indexOf(data);
        foods.remove(position);
        notifyItemRemoved(position);
    }
}
