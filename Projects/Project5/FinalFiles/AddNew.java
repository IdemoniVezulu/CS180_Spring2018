package edu.purdue.ramakri7.project5;

/**
 *  Add New Counter Class - Project 5
 *
 *  This class is used to add a new counter to the list.
 *
 *  @author Varun Ramakrishnan
 *  @version 21st April, 2018
 *
 */

import android.support.v7.app.AppCompatActivity;

/**
 *  New CounterData Name Class - Project 5
 *
 * This class if used to
 *
 * @author Varun Ramakrishnan, L09
 * @version
 *
 */

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;

public class AddNew extends AppCompatActivity
{
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_new);

        Button                      set = findViewById(R.id.setNewName);

        final ArrayList<CounterData>    counters = getIntent().getParcelableArrayListExtra("counters");

                                    set.setOnClickListener(new View.OnClickListener()
                                    {
                                        public void onClick(View v)
                                        {
                                            EditText    nameField = findViewById(R.id.newName);
                                            String      newName = nameField.getText().toString();

                                                        counters.add(new CounterData(newName));

                                            Intent      intent = new Intent(getApplicationContext(), MainActivity.class);

                                                        intent.putParcelableArrayListExtra("counters", counters);

                                                        startActivity(intent);
                                        }
                                    });
    }
}
