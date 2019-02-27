package edu.purdue.ramakri7.project5;

/**
 *  Main Activity Class - Project 5
 *
 *  This is the main activity for the app.
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
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity
{

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Bundle                  bundle = getIntent().getExtras();
        ArrayList<CounterData>  counters;

                            try
                            {
                                counters = bundle.getParcelableArrayList("counters");

                                if(counters == null)
                                {
                                    throw new NullPointerException("You are pointing to a null value");
                                }
                            }
                            catch (NullPointerException e)
                            {
                                counters = new ArrayList<>();
                                counters.add(new CounterData("Default", 0));
                            }

                            Log.d("COUNTERS", counters.toString());

        final ArrayList<CounterData>    finalCounters = counters;
        final ListView                  counterList = (ListView) findViewById(R.id.countersList);

                                        for(int i = 0; i < counters.size(); i++)
                                        {
                                            CounterData count = counters.get(i);

                                            Button      toAdd = new Button(getApplicationContext());

                                                        toAdd.setText(count.toString());
                                                        counterList.addHeaderView(toAdd);

                                            final int   lastIndex = i;

                                                        toAdd.setOnClickListener(new View.OnClickListener()
                                                        {
                                                            @Override
                                                            public void onClick(View v)
                                                            {
                                                                Intent  intent = new Intent(getApplicationContext(), Counter.class);

                                                                        intent.putExtra("from", lastIndex);
                                                                        intent.putParcelableArrayListExtra("counters", finalCounters);

                                                                        Log.d("COUNTER", "Starting Count of CounterData class");

                                                                        startActivity(intent);
                                                            }
                                                        });
                                        }

        Button  addCount = findViewById(R.id.addCount);

                addCount.setOnClickListener(new View.OnClickListener()
                {
                    @Override
                    public void onClick(View v)
                    {
                        Intent  intent = new Intent(getApplicationContext(), AddNew.class);

                                intent.putParcelableArrayListExtra("counters", finalCounters);

                                startActivity(intent);
                    }
                });

        final String[]    countArray = new String[finalCounters.size()];

                    for(int i = 0; i < finalCounters.size(); i++)
                    {
                        countArray[i] = finalCounters.get(i).toString();
                    }

        final ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, countArray);

                    counterList.setAdapter(arrayAdapter);
                    //counterList.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, countArray));

                    counterList.setOnItemClickListener(new AdapterView.OnItemClickListener()
                    {
                        @Override
                        public void onItemClick(AdapterView<?> arr, View view, int position, long id)
                        {
                            Intent  intent = new Intent(getApplicationContext(), Counter.class);
                            CounterData selected = finalCounters.get(counterList.getPositionForView(view) + 1);

                                    intent.putExtra("from", selected);

                            Bundle  extras = new Bundle();

                                    extras.putInt("from", selected.getCounterValue());
                                    intent.putExtras(extras);

                                    intent.putParcelableArrayListExtra("counters", finalCounters);

                                    startActivity(intent);
                        }
                    });

        Button  autoBut = findViewById(R.id.Auto);

                autoBut.setOnClickListener(new View.OnClickListener()
                {
                    @Override
                    public void onClick(View v)
                    {
                        for(int i = 0; i < finalCounters.size(); i++)
                        {
                            finalCounters.get(i).setCounterValue(finalCounters.get(i).getCounterValue() + 1);

                            countArray[i] = finalCounters.get(i).toString();

                            arrayAdapter.notifyDataSetChanged();
                        }
                    }
                });
    }
}
