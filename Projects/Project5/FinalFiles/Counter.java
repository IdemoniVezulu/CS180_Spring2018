package edu.purdue.ramakri7.project5;

/**
 * Counter Class - Project 5
 *
 * This class is used to increment the counters.
 *
 * @author Varun Ramakrishnan
 * @version 21st April, 2018
 *
 */

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;

public class Counter extends AppCompatActivity
{
    public void onCreate(Bundle savedForInstance)
    {
        super.onCreate(savedForInstance);
        setContentView(R.layout.activity_counter);

        final Bundle  bundle = getIntent().getExtras();

        Button  count = findViewById(R.id.countButton);

        final ArrayList<CounterData>    counters = getIntent().getParcelableArrayListExtra("counters");

                //bundle.putInt("Value", counter);

                if(bundle != null)
                {
                    int         initialCounterValue = bundle.getInt("Value");//Get the "Value" from the bundle.
                    EditText    valueEditText = findViewById(R.id.valueEditText);

                    valueEditText.setText(String.format("%d", initialCounterValue));
                }

                count.setOnClickListener(new View.OnClickListener()
                {
                    @Override
                    public void onClick(View v)
                    {
                        Intent      intent = new Intent(getApplicationContext(), MainActivity.class);
                        EditText    valueText = findViewById(R.id.valueEditText);
                        String      newValue = valueText.getText().toString();

                        Bundle      extras = new Bundle();

                                    extras.putInt("from", Integer.parseInt(newValue));
                                    intent.putExtras(extras);

                        final ArrayList<CounterData>    finalCounters = counters;
                        CounterData counterInc = counters.get(bundle.getInt("from"));


                                    intent.putParcelableArrayListExtra("counters", finalCounters);

                                    counterInc.setCounterValue(counterInc.getCounterValue() + 1);

                                    valueText.setText(String.format("%d", counterInc.getCounterValue()));
                        /*counter = newVal.getInt("from");
                                    //counter = finalCounters.get(intent.)
                                    newVal.putInt("value", newVal.getInt("from"));

                                    counter++;

                                    valueText.setText(String.format("%d", counter));*/
                    }
                });

        Button  done = findViewById(R.id.doneButton);

                done.setOnClickListener(new View.OnClickListener()
                {
                    @Override
                    public void onClick(View v)
                    {
                        Intent  intent = new Intent(getApplicationContext(), MainActivity.class);

                        EditText    valueText = findViewById(R.id.valueEditText);

                                    bundle.putInt("from", Integer.parseInt(valueText.getText().toString()));

                                    intent.putParcelableArrayListExtra("counters", counters);

                                    startActivity(intent);
                    }
                });
    }
}
