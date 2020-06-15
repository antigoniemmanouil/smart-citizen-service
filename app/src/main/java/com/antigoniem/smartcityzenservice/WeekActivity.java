package com.antigoniem.smartcityzenservice;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class WeekActivity extends ToolbarActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ((RecyclerView) findViewById(R.id.recycler_view)).setAdapter(new CustomAdapter(getItems()));
    }

    @Override
    protected int getContentView() {
        return R.layout.activity_week;
    }

    @Override
    protected String getToolbarTitle() {
        return getIntent().getStringExtra("service");
    }

    private List<Model> getItems() {
        ArrayList<Model> items = new ArrayList<>();
        items.add(new Model("Δευτέρα", "10"));
        items.add(new Model("Τρίτη", "10"));
        items.add(new Model("Τετάρτη", "10"));
        items.add(new Model("Πέμπτη", "10"));
        items.add(new Model("Παρασκευή", "10"));
        return items;
    }
}
