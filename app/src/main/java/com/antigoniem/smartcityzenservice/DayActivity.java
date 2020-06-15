package com.antigoniem.smartcityzenservice;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.app.DatePickerDialog;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class DayActivity extends ToolbarActivity {

    private Button selectDateButton;
    private RecyclerView recyclerView;
    private TextView selectedDayTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        selectDateButton = findViewById(R.id.select_day_button);
        recyclerView = findViewById(R.id.recycler_view);
        selectedDayTextView = findViewById(R.id.selected_day_tv);

        recyclerView.setAdapter(new CustomAdapter(getItems()));
    }

    @Override
    protected int getContentView() {
        return R.layout.activity_day;
    }

    @Override
    protected String getToolbarTitle() {
        return getIntent().getStringExtra("service");
    }

    public List<Model> getItems() {
        List<Model> items = new ArrayList<>();
        items.add(new Model("08:00 - 08:30", "15"));
        items.add(new Model("08:30 - 09:00", "5"));
        items.add(new Model("09:00 - 09:30", "2"));
        items.add(new Model("09:30 - 10:00", "22"));
        items.add(new Model("10:00 - 10:30", "12"));
        items.add(new Model("10:30 - 11:00", "30"));
        items.add(new Model("11:00 - 11:30", "18"));
        items.add(new Model("11:30 - 12:00", "5"));
        items.add(new Model("12:00 - 12:30", "20"));
        items.add(new Model("12:30 - 13:00", "11"));

        return items;
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    public void selectDate(View view) {
        final Calendar newCalendar = Calendar.getInstance();
        DatePickerDialog  StartTime = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                Calendar newDate = Calendar.getInstance();
                newDate.set(year, monthOfYear, dayOfMonth);
                selectDateButton.setVisibility(View.GONE);
                selectedDayTextView.setVisibility(View.VISIBLE);
                recyclerView.setVisibility(View.VISIBLE);
                SimpleDateFormat dateFormatter = new SimpleDateFormat("dd/MM/yyyy");
                selectedDayTextView.setText(dateFormatter.format(newDate.getTime()));
            }

        }, newCalendar.get(Calendar.YEAR), newCalendar.get(Calendar.MONTH), newCalendar.get(Calendar.DAY_OF_MONTH));
        StartTime.show();
    }
}
