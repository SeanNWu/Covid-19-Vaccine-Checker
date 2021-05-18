package com.example.covid_19;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.ArrayList;

public class MainActivity4 extends AppCompatActivity {
    String name,date;
    EditText nameInput;
    EditText dateInput;
    Button submitButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);

        nameInput = (EditText)findViewById(R.id.Country_input);
        dateInput = (EditText)findViewById(R.id.Date_input);

        submitButton = (Button)findViewById(R.id.submit1);
        readVaccineData();

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                name = nameInput.getText().toString();
                date = dateInput.getText().toString();
                TextView output = (TextView)findViewById(R.id.Output1);

                for(int count =0; count < vaccinesSample.size()  ;count++)
                {

                    if((vaccinesSample.get(count).getCountry() + vaccinesSample.get(count).getDate()).equals(name+date))
                    {
                        output.setText("On the date " + vaccinesSample.get(count).getDate() + " " + vaccinesSample.get(count).getDailyPercentage() + " percent of people in " + vaccinesSample.get(count).getCountry() + " were vaccinated");
                    }


                    Log.d("MainActivity3", vaccinesSample.get(count).getCountry() + vaccinesSample.get(count).getDate());



                }




            }

        });



    }


    private ArrayList<VaccineSample> vaccinesSample = new ArrayList<>();
    private void readVaccineData(){

        InputStream is = getResources().openRawResource(R.raw.vaccine_type);
        BufferedReader reader = new BufferedReader(
                new InputStreamReader(is, Charset.forName("UTF-8"))
        );
        String line="";
        try{
            while((line=reader.readLine())!=null)
            {
                Log.d("MyActivity2","Line:    " + line);
                String[] tokens = line.split(",");
                VaccineSample sample = new VaccineSample();
                sample.setCountry(tokens[0]);
                sample.setDate(tokens[1]);
                //  sample.setVaccineType(tokens[2]);
               // sample.setNumberOfDose(tokens[2]);
                sample.setDailyPercentage(tokens[3]);

                vaccinesSample.add(sample);

                Log.d("MyActivity3","Just Created: " + sample);


            }
        }
        catch(IOException e)
        {
            Log.wtf("MyActivity4","Error reading data file on line " + line,e);
            e.printStackTrace();
        }


    }




}