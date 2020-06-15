package com.antigoniem.smartcityzenservice;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class Main2Activity extends ToolbarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected int getContentView() {
        return R.layout.activity_main2;
    }

    @Override
    protected String getToolbarTitle() {
        return "Επιλογή Υπηρεσίας";
    }

    public void dehButton(View view) {
        startActivity(new Intent(this, Main3Activity.class));
    }

    public void errorButton(View view) {
        Toast.makeText(this, "Σφάλμα!", Toast.LENGTH_SHORT).show();
    }

}
