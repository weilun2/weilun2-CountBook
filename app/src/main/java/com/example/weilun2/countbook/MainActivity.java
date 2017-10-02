/*
 * Copyright (c) weilun2, CUMPT301, University of Alberta - All Rights Reserved. You may use,distribute, or modify this code under terms and condition of the Code of Students Behavior at Univerisity og Alberta
 */

package com.example.weilun2.countbook;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.lang.reflect.Type;
import java.util.ArrayList;


/**
 * Represent the main project
 * Copy from my own lonelyTwitter project
 *
 *
 * @author: Weilun2
 * @version 1.0
 * @since 1.0
 */
public class MainActivity extends AppCompatActivity {
    private static final String FILENAME = "file.sav";
    private EditText editCounter;
    private EditText editValue;
    private ListView counterList;

    private ArrayList<Counter> counters = new ArrayList<Counter>();
    private ArrayAdapter<Counter> adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editCounter = (EditText) findViewById(R.id.editCounter);//declare layout
        editValue = (EditText) findViewById(R.id.editValue);
        Button addButton = (Button) findViewById(R.id.addCounter);
        counterList = (ListView) findViewById(R.id.counterList);

        /**
         * set the addButton
         */
        addButton.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                setResult(RESULT_OK);
                String text = editCounter.getText().toString();
                Integer number = Integer.valueOf(editValue.getText().toString());
                counters.add(new Counter(text, number));
                adapter.notifyDataSetChanged();
                saveInFile();

            }

        });
    }

    /**
     * start the project
     */
    protected void onStart() {
        // TODO Auto-generated method stub
        super.onStart();
        loadFromFile();

        adapter = new ArrayAdapter<Counter>(this,
                R.layout.list_counter, counters);
        counterList.setAdapter(adapter);
    }


        /**
         * Loads data from file
         */

    private void loadFromFile() {

        try {
            FileInputStream fis = openFileInput(FILENAME);
            BufferedReader in = new BufferedReader(new InputStreamReader(fis));
            Gson gson = new Gson();

            Type listType = new TypeToken<ArrayList<Counter>>(){}.getType();
            counters = gson.fromJson(in,listType);


        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            counters = new ArrayList<Counter>();


        } catch (IOException e) {
            // TODO Auto-generated catch block
            throw new RuntimeException();
        }
    }

    /**
     * Saves data in file
     */

    private void saveInFile() {
        try {
            FileOutputStream fos = openFileOutput(FILENAME,
                    Context.MODE_PRIVATE);
            OutputStreamWriter writer = new OutputStreamWriter(fos);
            Gson gson = new Gson();
            gson.toJson(counters,writer);
            writer.flush();


            fos.close();
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            throw new RuntimeException();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            throw new RuntimeException();
        }
    }
}
