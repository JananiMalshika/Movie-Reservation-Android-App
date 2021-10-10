package com.example.blueskycinema.Janani;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.example.blueskycinema.DB_Handler;
import com.example.blueskycinema.R;

public class FoodList extends AppCompatActivity {
    TextView count;
    Context context;
    RecyclerView mRecyclerView;
    DB_Handler databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_list);

        mRecyclerView = findViewById(R.id.recyclerView);
        databaseHelper = new DB_Handler(this);

        showRecord();

        count=findViewById(R.id.foodCount);
        context= this;

        //Get food count from the table
        int countFoodList = databaseHelper.countFoodList();
        count.setText("There are "+countFoodList+" food items");
    }
        private void showRecord() {
            FoodAdapter adapter = new FoodAdapter(FoodList.this, databaseHelper.getAllFoodData(DB_Handler.FOOD_COLUMN_NAME+ " DESC"));
                mRecyclerView.setAdapter(adapter);
        }
        @Override
         protected void onResume() {
            super.onResume();
            showRecord();
        }

        public void loadAddFood (View view){
            setContentView(R.layout.activity_add_food);
            Intent intent = new Intent(this, AddFood.class);
            startActivity(intent);
        }
}

