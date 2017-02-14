package com.example.drivelesson;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import java.util.Date;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    public final static float MIL_TO_HOUR = 60 * 60 * 1000;

    private Date startDate;
    private TextView dateView;
    private TextView hoursView;
    private Button start;
    private Button stop;
    private float hourDiff;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.dateView = (TextView) findViewById(R.id.dateView);
        this.hoursView = (TextView) findViewById(R.id.hoursView);
        this.start = (Button) findViewById(R.id.start);
        this.stop = (Button) findViewById(R.id.stop);
        this.hourDiff = 0;

        this.dateView.setText(R.string.date);
        this.hoursView.setText(R.string.elapsed_time);
        this.start.setEnabled(true);
        this.stop.setEnabled(false);
    }

    public void startClock(View view) {
        this.startDate = new Date();
        this.dateView.setText(android.text.format.DateFormat.format("M/d/yy", this.startDate));
        this.hoursView.setText(R.string.elapsed_time);
        this.start.setEnabled(false);
        this.stop.setEnabled(true);
    }

    public void stopClock(View view) {
        Date stopDate = new Date();
        this.hourDiff = (stopDate.getTime() - this.startDate.getTime()) / MIL_TO_HOUR;
        this.hoursView.setText(String.format("%.2f", hourDiff));
        this.start.setEnabled(true);
        this.stop.setEnabled(false);
    }
}
