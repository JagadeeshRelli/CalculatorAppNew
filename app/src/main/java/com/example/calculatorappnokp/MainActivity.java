package com.example.calculatorappnokp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView tv;
    EditText tn1,tn2;
    Button add, mul, sub,div,clear;
    public double res;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv=findViewById(R.id.tv);
        tn1=findViewById(R.id.tn1);
        tn2=findViewById(R.id.tn2);
        add=findViewById(R.id.add);
        sub=findViewById(R.id.sub);
        mul=findViewById(R.id.mul);
        div=findViewById(R.id.div);
        clear=findViewById(R.id.clear);

        if(savedInstanceState!=null)
        {

            tn1.setText(String.valueOf(savedInstanceState.getDouble("key1")));
            tn2.setText(String.valueOf(savedInstanceState.getDouble("key2")));
            tv.setText(String.valueOf(savedInstanceState.getDouble("res")));


        }

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                res=Double.parseDouble(tn1.getText().toString())+Double.parseDouble(tn2.getText().toString());
                tv.setText(res+"");
            }
        });
        sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                res=Double.parseDouble(tn1.getText().toString())-Double.parseDouble(tn2.getText().toString());
                tv.setText(res+"");
            }
        });mul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                res=Double.parseDouble(tn1.getText().toString())*Double.parseDouble(tn2.getText().toString());
                tv.setText(res+"");
            }
        });div.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                res=Double.parseDouble(tn1.getText().toString())/Double.parseDouble(tn2.getText().toString());
                tv.setText(res+"");
            }
        });
        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                res=0;
                tv.setText("result");
                tn1.setText("enter 1st number");
                tn2.setText("enter 2nd number");
            }
        });




    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);

        outState.putDouble("key1",Double.parseDouble(tn1.getText().toString()));
        outState.putDouble("key2",Double.parseDouble(tn2.getText().toString()));
        outState.putDouble("res",Double.parseDouble(tv.getText().toString()));
    }
}