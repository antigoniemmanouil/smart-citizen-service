package com.antigoniem.smartcityzenservice;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main4Activity extends ToolbarActivity {

    private int sum = 0;
    private CustomAdapter listAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        RecyclerView recyclerView = findViewById(R.id.firstList);
        List<Model> items = getItems();
        listAdapter = new CustomAdapter(items);
        recyclerView.setAdapter(listAdapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.action_refresh) {
            listAdapter.updateItems(getItems());
        }
        return super.onOptionsItemSelected(item);
    }

    private List<Model> getItems() {
        List<Model> items = new ArrayList<>();
        int value = new Random().nextInt(50);
        items.add(new Model("Σε αναμονή", Integer.toString(value)));
        items.add(new Model("Έχουν εξυπηρετηθεί", Integer.toString(sum)));
        sum += value;
        return items;
    }

    @Override
    protected int getContentView() {
        return R.layout.activity_main4;
    }

    @Override
    protected String getToolbarTitle() {
        return "Τρέχουσες Μετρήσεις";
    }

}
