package com.example.mirzanikolic;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.List;

public class DetailsActivity extends AppCompatActivity {
    EditText model, color, price, memory, camera, year;
    Button save, cancel;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        model = findViewById(R.id.model);
        color = findViewById(R.id.color);
        price = findViewById(R.id.price);
        memory = findViewById(R.id.memory);
        camera = findViewById(R.id.camera);
        year = findViewById(R.id.year);
        save = findViewById(R.id.button_save);
        cancel = findViewById(R.id.button_cancel);

        Bundle extras = getIntent().getExtras();
        if(extras!=null){
            long id = extras.getLong(MainActivity.EXTRA_MESSAGE);
            Intent intent = new Intent(DetailsActivity.this, MainActivity.class);
            Mobile mobile = AppDatabase.getInstance(this).mobileDao().getMobileId(id);
            model.setText(mobile.getModel());
            color.setText(mobile.getColor());
            price.setText(mobile.getPrice());
            memory.setText(mobile.getMemory());
            camera.setText(mobile.getColor());
            year.setText(mobile.getYear_of_manufacturing());

            cancel.setText("Delete");

            cancel.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    AppDatabase.getInstance(getApplicationContext()).mobileDao().delete(mobile);
                    Toast.makeText(DetailsActivity.this, "User deleted", Toast.LENGTH_SHORT).show();
                    startActivity(intent);
                }
            });
        }
    }



    public void onCancel(View view){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    public void onSave(View view){
        Mobile mobile = new Mobile(model.getText().toString(), color.getText().toString(), memory.getText().toString(), price.getText().toString(), camera.getText().toString(), year.getText().toString());
        AppDatabase.getInstance(this).mobileDao().add(mobile);
        Toast.makeText(this, "User added", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}