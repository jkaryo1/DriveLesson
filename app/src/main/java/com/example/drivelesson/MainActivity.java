package com.example.drivelesson;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    private Date date;
    private TextView dateField;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        dateField = (TextView) findViewById(R.id.textView);
    }

    public void startClock(View view) {
        date = new Date();
        dateField.setText(android.text.format.DateFormat.format("M/d/yy", date));

    }
}
