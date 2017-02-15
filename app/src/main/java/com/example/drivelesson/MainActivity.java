package com.example.drivelesson;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import java.util.Date;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    public final static int SIXTY = 60;
    public final static int THOUSAND = 1000;

    private Date startDate;
    private TextView dateView;
    private TextView hoursView;
    private Button start;
    private Button stop;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.dateView = (TextView) findViewById(R.id.dateView);
        this.hoursView = (TextView) findViewById(R.id.hoursView);
        this.start = (Button) findViewById(R.id.start);
        this.stop = (Button) findViewById(R.id.stop);
        Spinner lesson = (Spinner) findViewById(R.id.lessonOptions);
        Spinner weather = (Spinner) findViewById(R.id.weatherOptions);

        ArrayAdapter<CharSequence> lessonAdapter = ArrayAdapter.createFromResource(this,
                R.array.lesson_array, android.R.layout.simple_spinner_item);
        lessonAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        lesson.setAdapter(lessonAdapter);
        ArrayAdapter<CharSequence> weatherAdapter = ArrayAdapter.createFromResource(this,
                R.array.weather_array, android.R.layout.simple_spinner_item);
        weatherAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        weather.setAdapter(weatherAdapter);
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
        float hourDiff;
        long milDiff;
        String text;
        Date stopDate = new Date();
        milDiff = stopDate.getTime() - this.startDate.getTime();
        hourDiff = (float)milDiff / (SIXTY * SIXTY * THOUSAND);
        text = String.format(Locale.getDefault(), "%.2f", hourDiff) + " hours";
        this.hoursView.setText(text);
        this.start.setEnabled(true);
        this.stop.setEnabled(false);
    }
}
