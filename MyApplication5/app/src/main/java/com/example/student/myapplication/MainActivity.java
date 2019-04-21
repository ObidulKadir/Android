package com.example.student.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button btnbus,btntrain,btncar,btnbike;
    TextView tvResult;
    EditText edttext;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnbus=(Button) findViewById(R.id.btnbus);
        btncar=(Button) findViewById(R.id.btncar);
        btnbike=(Button) findViewById(R.id.btnbike);
        btntrain=(Button) findViewById(R.id.btntrain);

        edttext=(EditText) findViewById(R.id.edttext);
        tvResult=(TextView) findViewById(R.id.tvResult);


        btnbus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                function((double) 5);
            }
        });
        btntrain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                function((double) 2);
            }
        });
        btnbike.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                function((double) 10);
            }
        });
        btncar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                function((double) 8);
            }
        });

    }
    public void function(Double cost){

        Double dist=Double.parseDouble(edttext.getText().toString());
        cost=cost * dist;
        tvResult.setText(cost.toString());
    }
}
