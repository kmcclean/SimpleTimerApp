package com.example.kevin.simpletimerapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Date;

public class SimpleTimeTapRecorderActivity extends AppCompatActivity {

    Button mTapButton;
    ListView mTimeText;
    ArrayList<String> dateArray = new ArrayList<>();
    ArrayAdapter<String> listAdapter;

    //fetches the date from the system and turns it into a string.
    public String getSystemTime(){
        Date timeDate = new Date();
        String timeString = timeDate.toString();
        return timeString;
    }

    //puts the date into the dateArray and then lets the adapter know that something has changed.
    public void setListTime(String time){
        dateArray.add("The time is " + time + ".");
        listAdapter.notifyDataSetChanged();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simple_time_tap_recorder);

        mTapButton = (Button)findViewById(R.id.tapButton);
        mTimeText = (ListView)findViewById(R.id.recordedTime);
        listAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, dateArray);
        mTimeText.setAdapter(listAdapter);

        //runs the time recording on the computer.
        mTapButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String time = getSystemTime();
                setListTime(time);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_simple_time_tap_recorder, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
