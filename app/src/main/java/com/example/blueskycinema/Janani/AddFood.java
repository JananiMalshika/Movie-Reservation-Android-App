package com.example.blueskycinema.Janani;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.blueskycinema.DB_Handler;
import com.example.blueskycinema.R;

public class AddFood extends AppCompatActivity {

    EditText editTextTextPersonName3,editTextTextPersonName5;
    Context context;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_food);

        editTextTextPersonName3 = findViewById(R.id.editTextTextPersonName3);
        editTextTextPersonName5 = findViewById(R.id.editTextTextPersonName5);
        context=this;
    }

    public void submitFood (View view) {
        if (editTextTextPersonName3.length() == 0) {
            editTextTextPersonName3.setError("Enter Food Name");
        }
        else if (editTextTextPersonName3.length() > 20) {
            editTextTextPersonName3.setError("Maximum 20 Characters");
        }
        else if (editTextTextPersonName5.length() == 0) {
            editTextTextPersonName5.setError("Enter Price");
        }
        else {

            DB_Handler db = new DB_Handler(this);
            long val = db.addFood(editTextTextPersonName3.getText().toString(), editTextTextPersonName5.getText().toString());
            if (val > 0) {
                Toast.makeText(this, "Data inserted successfully!!!", Toast.LENGTH_SHORT).show();

            } else {
                Toast.makeText(this, "Data not inserted!!!", Toast.LENGTH_SHORT).show();
            }

            startActivity(new Intent(context, FoodList.class));

        }
    }
}





