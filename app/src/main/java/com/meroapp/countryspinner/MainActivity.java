package com.meroapp.countryspinner;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {

    private Spinner spinnerCountry,spinnerPlayer;
    private AutoCompleteTextView autoCompleteNepleasePlayer;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spinnerCountry = findViewById(R.id.spinnerCountry);
        spinnerPlayer = findViewById(R.id.spinnerPlayer);
        autoCompleteNepleasePlayer = findViewById(R.id.autoCompleteNepleasePlayer);


        String countries[] = {"Nepal","China"};
        final String playersNepal[] = {"Paras","Sompal"};
        final String playersChina[] = {"xi","lee"};
        final ArrayAdapter adapter = new ArrayAdapter<>(

                this,
                android.R.layout.simple_list_item_1,countries


        );
        spinnerCountry.setAdapter(adapter);

        spinnerCountry.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if(spinnerCountry.getSelectedItem().toString().equals("Nepal")){
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(
                            MainActivity.this,
                            android.R.layout.simple_list_item_1,
                            playersNepal
                    );
                    spinnerPlayer.setAdapter(arrayAdapter);
                }
                else {
                    ArrayAdapter arrayAdapter = new ArrayAdapter<>(
                            MainActivity.this,
                            android.R.layout.simple_list_item_1,
                            playersChina
                    );
                    spinnerPlayer.setAdapter(arrayAdapter);
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }

            ArrayAdapter<String> stringArrayAdapter= new ArrayAdapter<>(
                    this,
                    android.R.layout.select_dialog_item,
                    playersNepal
            );
            autoCompleteNepleasePlayer.setAdapter



        });

    }
}
