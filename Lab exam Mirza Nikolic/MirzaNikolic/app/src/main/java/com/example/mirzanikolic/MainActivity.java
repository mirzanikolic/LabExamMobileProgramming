package com.example.mirzanikolic;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    private ListView listView;
    public static final String EXTRA_MESSAGE = "MainActivity/EXTRA_MESSAGE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.list_item_container);
        getAllMobiles();

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                long itemId = adapterView.getItemIdAtPosition(i);
                Intent intent = new Intent(MainActivity.this, DetailsActivity.class);
                intent.putExtra(EXTRA_MESSAGE, itemId);
                startActivity(intent);
            }
        });
    }


    private void getAllMobiles(){
        List<Mobile> mobiles = AppDatabase.getInstance(this).mobileDao().getAll();
        ListAdapter adapter = new ListAdapter(this, mobiles);
        listView.setAdapter(adapter);
    }


    public void startAct(View view){
        Intent intent = new Intent(MainActivity.this, DetailsActivity.class);
        startActivity(intent);
    }
}