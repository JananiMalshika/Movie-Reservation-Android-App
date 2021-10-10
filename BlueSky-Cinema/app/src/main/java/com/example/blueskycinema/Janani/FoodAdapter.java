package com.example.blueskycinema.Janani;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.blueskycinema.DB_Handler;
import com.example.blueskycinema.R;

import java.util.ArrayList;

public class FoodAdapter extends RecyclerView.Adapter<FoodAdapter.Holder> {

        private Context context;
        private ArrayList<FoodModelClass> arrayList;
        private DB_Handler db_handler;

        //Database Object
        DB_Handler databaseHelper;
        public FoodAdapter(Context context, ArrayList<FoodModelClass> arrayList) {
            this.context = context;
            this.arrayList = arrayList;
            db_handler = new DB_Handler(context);
            databaseHelper = new DB_Handler(context);
        }
        @NonNull
        @Override
        public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(context).inflate(R.layout.single_food, parent, false);
            return new Holder(view);
        }
        @Override
        public void onBindViewHolder(@NonNull Holder holder, int position) {
            FoodModelClass model = arrayList.get(position);

            //Get for view
            String id = model.getFoodID();
            String name = model.getFoodName();
            String price = model.getFoodPrice();

            //Set view
            holder.FName.setText(name);
            holder.FPrice.setText(price);

            //update food
            holder.editButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(context, EditFood.class);
                    intent.putExtra("ID", String.valueOf(model.getFoodID()));
                    context.startActivity(intent);
                }
            });

            //Delete Button
            holder.itemView.setOnLongClickListener(new View.OnLongClickListener(){
                @Override
                public boolean onLongClick(View v) {
                    deleteDialog(
                            ""+ id
                    );
                    return false;
                }
            });
        }


        //Delete function
        private void deleteDialog(String id) {
            AlertDialog.Builder builder = new AlertDialog.Builder(context);
            builder.setTitle("Delete");
            builder.setMessage("Are you sure want to Delete?");
            builder.setCancelable(false);
            builder.setIcon(R.drawable.ic_baseline_delete_24);
            builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    databaseHelper.deleteInfo(id);
                    ((FoodList)context).onResume();
                    Toast.makeText(context, "Successfully Deleted!", Toast.LENGTH_SHORT).show();
                }
            });
            builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialog.cancel();
                }
            });
            builder.create().show();

     }

        @Override
        public int getItemCount() {
            return arrayList.size();
        }
        class Holder extends RecyclerView.ViewHolder {
            TextView FName,FPrice;

            ImageView editButton;
            public Holder(@NonNull View itemView) {
                super(itemView);
                FName = itemView.findViewById(R.id.Foodname);
                FPrice = itemView.findViewById(R.id.Foodprice);

            editButton = itemView.findViewById(R.id.FoodListUpdate);
            }
        }
}
