package com.rudy.java_android_selected_and_selectall;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements QuantityRVAdapter.IQuantityRVAdapter {

    RecyclerView recycler_view ;
    QuantityRVAdapter quantityRVAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recycler_view = findViewById(R.id.recycler_view);

        setRecycleView();
    }

    private ArrayList<String> getQuantityData(){
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("10 kg");
        arrayList.add("20 kg");
        arrayList.add("30 kg");
        arrayList.add("40 kg");
        arrayList.add("50 kg");
        arrayList.add("60 kg");
        arrayList.add("70 kg");
        arrayList.add("9 kg");

        return  arrayList;
    }

    private void setRecycleView() {
        recycler_view.setHasFixedSize(true);
        recycler_view.setLayoutManager(new LinearLayoutManager(this));
        quantityRVAdapter = new QuantityRVAdapter(this,getQuantityData(),this::onQuantityChange);
        recycler_view.setAdapter(quantityRVAdapter);
    }

    @Override
    public void onQuantityChange(ArrayList<String> arrayList) {
        //TODO
        Toast.makeText(this, arrayList.toString(), Toast.LENGTH_SHORT).show();
    }
}