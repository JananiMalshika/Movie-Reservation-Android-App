package com.example.blueskycinema;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.blueskycinema.Hasith.add_movies;
import com.example.blueskycinema.Janani.AddFood;
import com.example.blueskycinema.Janani.FoodList;
import com.example.blueskycinema.Zaid.ReserveNowActivity;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        

    }
    public void loadFoodList (View view){
        setContentView(R.layout.activity_food_list);
        Intent intent = new Intent(this, FoodList.class);
        startActivity(intent);
    }

}