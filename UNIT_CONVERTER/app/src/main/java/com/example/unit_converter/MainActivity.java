package com.example.unit_converter;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    Button kilo , meter , deci , centi ,milli , micron;
    TextView tv;
    EditText ed;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_main);
        kilo = findViewById(R.id.button);
        meter = findViewById(R.id.button2);
        deci = findViewById(R.id.button3);
        centi = findViewById(R.id.button4);
        milli = findViewById(R.id.button5);
        micron = findViewById(R.id.button6);
        tv = findViewById(R.id.textView2);
        ed = findViewById(R.id.editTextNumberDecimal);

        kilo.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View view) {
                  String num = ed.getText().toString();
                  int number = Integer.parseInt(num);
                  double op1 = (number*0.001);
                  tv.setText("Value in kilo : " + op1 + "kg" );
            }
        });
        meter.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View view) {
                String num = ed.getText().toString();
                int number = Integer.parseInt(num);
                tv.setText("Value in meter : "+ (double) (number) +"m");
            }
        });
        deci.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View view) {
                String num = ed.getText().toString();
                int number = Integer.parseInt(num);
                double op3 = (number*10);
                tv.setText("Value in  deci : "+ op3 +"dm");
            }
        });
        centi.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View view) {
                String num = ed.getText().toString();
                int number = Integer.parseInt(num);
                double op4 = (number*100);
                tv.setText("Value in centi : "+ op4 +"cm");
            }
        });
        milli.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View view) {
                String num = ed.getText().toString();
                int number = Integer.parseInt(num);
                double op5 = (number*1000);
                tv.setText("Value in milli : "+op5 +"mm");
            }
        });
        micron.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View view) {
                String num = ed.getText().toString();
                int number = Integer.parseInt(num);
                double op6 = (number*1000000);
                tv.setText("Value in micron : "+op6 +"micron");
            }
        });

    }
}