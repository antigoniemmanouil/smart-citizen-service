package com.antigoniem.smartcityzenservice;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Main3Activity extends ToolbarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    public void counterButton(View view) {
        startActivity(new Intent(this, Main4Activity.class));
    }

    public void weekButton(View view) {
        Intent intent = new Intent(this, WeekActivity.class);
        intent.putExtra("service", "ΔΕΗ");
        startActivity(intent);
    }

    @Override
    protected String getToolbarTitle() {
        return "ΔΕΗ";
    }

    @Override
    protected int getContentView() {
        return R.layout.activity_main3;
    }

    public void dayButton(View view) {
        Intent intent = new Intent(this, DayActivity.class);
        intent.putExtra("service", "ΔΕΗ");
        startActivity(intent);
    }
}
