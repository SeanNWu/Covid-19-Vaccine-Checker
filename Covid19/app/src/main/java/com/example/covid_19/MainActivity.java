package com.example.covid_19;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Button button; //instance variables
    private Button button2;
    private Button button3;
    private Button button4;


    @Override
    protected void onCreate(Bundle savedInstanceState) {//buttons
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button4 = (Button) findViewById(R.id.button4);
//set up buttons
        button = (Button)findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() { //this is to open activity2
            @Override
            public void onClick(View v) {
                openActivity2();
            }
        });

        button2 = (Button)findViewById(R.id.button2); //set up button
        button2.setOnClickListener(new View.OnClickListener() { //this is to open activity 3
            @Override
            public void onClick(View v) {
                openActivity3();
            }
        });
        button3 = (Button)findViewById(R.id.button3); //set up button
        button3.setOnClickListener(new View.OnClickListener() { //this is activity 4
            @Override
            public void onClick(View v) {
                openActivity4();
            }
        });
        button4.setOnClickListener(new View.OnClickListener () { // this is to share the app
            @Override
            public void onClick(View v){
                Intent myIntent = new Intent(Intent.ACTION_SEND);
                myIntent.setType("text/plain");
                String body = "https://drive.google.com/file/d/1z35Y7utcE0C1oJTeWwJ_jCfGMnfazgMB/view?usp=sharing";
                String sub = "Covid-19 Tracker";
                myIntent.putExtra(Intent.EXTRA_SUBJECT,sub);
                myIntent.putExtra(Intent.EXTRA_TEXT,body);
                startActivity(Intent.createChooser(myIntent, "Share Using"));

            }
        });

    }



    public void openActivity2()
    {
        Intent intent = new Intent(this, MainActivity2.class);
        startActivity(intent);

    }
    public void openActivity3()
    {
        Intent intent = new Intent(this, MainActivity3.class);
        startActivity(intent);

    }
    public void openActivity4()
    {
        Intent intent = new Intent(this, MainActivity4.class);
        startActivity(intent);

    }
}