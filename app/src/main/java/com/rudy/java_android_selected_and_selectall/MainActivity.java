package com.rudy.java_android_selected_and_selectall;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.rudy.java_android_selected_and_selectall.model.QuantityModel;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements QuantityRVAdapter.IQuantityRVAdapter {

    RecyclerView recycler_view ;
    QuantityRVAdapter quantityRVAdapter;
    Button btn_all;
    Button btn_clear;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recycler_view = findViewById(R.id.recycler_view);
        btn_all = findViewById(R.id.btn_all);
        btn_clear = findViewById(R.id.btn_clear);

        btn_all.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                quantityRVAdapter.setSelectedAll();
            }
        });

        btn_clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                quantityRVAdapter.removeAll();
            }
        });

        setRecycleView();
    }

    private ArrayList<QuantityModel> getQuantityData(){
        ArrayList<QuantityModel> arrayList = new ArrayList<>();
        arrayList.add(new QuantityModel("10 kg",false));
        arrayList.add(new QuantityModel("11 kg",false));
        arrayList.add(new QuantityModel("12 kg",false));
        arrayList.add(new QuantityModel("13 kg",false));
        arrayList.add(new QuantityModel("14 kg",false));
        arrayList.add(new QuantityModel("15 kg",false));
        return  arrayList;
    }

    private void setRecycleView() {
        recycler_view.setHasFixedSize(true);
        recycler_view.setLayoutManager(new LinearLayoutManager(this));
        quantityRVAdapter = new QuantityRVAdapter(this,getQuantityData(),this::onQuantityChange);
        recycler_view.setAdapter(quantityRVAdapter);
    }

    @Override
    public void onQuantityChange(ArrayList<QuantityModel> arrayList) {
        //TODO
        Toast.makeText(this, arrayList.toString(), Toast.LENGTH_SHORT).show();
    }
}