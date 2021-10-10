package com.example.blueskycinema.Janani;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.blueskycinema.DB_Handler;
import com.example.blueskycinema.R;

public class EditFood extends AppCompatActivity {

    private EditText editTextFoodName, editTextFoodPrice;
    Button buttonSave;

    DB_Handler db_handler;
    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_food);

        context = this;
        db_handler = new DB_Handler(context);

        editTextFoodName = findViewById(R.id.editTextFoodName);
        editTextFoodPrice = findViewById(R.id.editTextFoodPrice);
        buttonSave = findViewById(R.id.buttonEdit);

        final String id = getIntent().getStringExtra("ID");

        FoodModelClass FModel = db_handler.getSingleFood(Integer.parseInt(id));

        //display previous added details
        editTextFoodName.setText(FModel.getFoodName());
        editTextFoodPrice.setText(FModel.getFoodPrice());


        //update button
        buttonSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String FName = editTextFoodName.getText().toString();
                String FPrice = editTextFoodPrice.getText().toString();

                FoodModelClass FModel = new FoodModelClass(id, FName, FPrice);
                int status = db_handler.updateInfo(FModel);
                if (status == 1){
                    startActivity(new Intent(context, FoodList.class));
                    Toast.makeText(EditFood.this, "Updated Successfully!", Toast.LENGTH_SHORT).show();
                }
                else {
                    Toast.makeText(EditFood.this, "Not Updated!", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}

