package edu.purdue.ramakri7.project5;

/**
 *  Count of Counters Class - Project 5
 *
 *  This class
 *
 *  @author Varun Ramakrishnan, L09
 *  @version 21st April, 2018
 *
 */

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;

public class CountOfCounter extends AppCompatActivity
{
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_count_of);

        Log.d("COUNTER", "Receiving from: ");

        final int                   from = getIntent().getIntExtra("From", -1);
        final ArrayList<CounterData>    counters = getIntent().getParcelableArrayListExtra("counters");

                                    if(from == -1)
                                    {
                                        throw new IllegalArgumentException("Receiving from wrong ID");
                                    }

                                    Log.d("COUNTER", "from: " + from);

        EditText                    displayCounter = findViewById(R.id.counterDisplay);

                                    Log.d("COUNTER", "Value being set");

                                    displayCounter.setText(String.valueOf(counters.get(from).getCounterValue()));

                                    Log.d("COUNTER", "Click listener starting...");

        Button                      done = findViewById(R.id.counterDone);

                                    done.setOnClickListener(new View.OnClickListener()
                                    {
                                        @Override
                                        public void onClick(View v)
                                        {
                                            Intent      intent = new Intent(getApplicationContext(), MainActivity.class);
                                            EditText    valueCont = findViewById(R.id.counterDisplay);

                                            int         value = Integer.valueOf(valueCont.getText().toString());

                                            CounterData newCount = new CounterData(counters.get(from).getCounterName(), value);

                                                        counters.set(from, newCount);

                                                        startActivity(intent);
                                        }
                                    });
    }
}
