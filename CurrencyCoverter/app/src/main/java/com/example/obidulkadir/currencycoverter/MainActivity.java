package com.example.obidulkadir.currencycoverter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button btnCad,btnUsd,btnEur;
    EditText edttext;
    TextView tvResult;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnCad = (Button) findViewById(R.id.btnCad);
        btnEur = (Button) findViewById(R.id.btnEur);
        btnUsd = (Button) findViewById(R.id.btnUsd);

        edttext = (EditText) findViewById(R.id.edttext);
        tvResult = (TextView) findViewById(R.id.tvResult);

        btnCad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Double e = Double.parseDouble(edttext.getText().toString());
                Double cost = e *.016;
                Toast.makeText(getApplicationContext(),cost.toString() + " cad ",Toast.LENGTH_LONG).show();
            }
        });

        btnEur.setOnClickListener(new View.OnClickListener(){
            @Override
            public  void onClick(View view){
                    function(view);
            }
        });
        btnUsd.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                    function(view);
            }
        });
    }
    public void function(View view){
        switch (view.getId()){
            case R.id.btnUsd:
                Double d = Double.parseDouble(edttext.getText().toString());
                tvResult.setText( .012 * d + " USD");
                break;
            case R.id.btnEur:
                d = Double.parseDouble(edttext.getText().toString());
                tvResult.setText( .0097 * d + " EUR");
                break;

            case  R.id.btnCad:
                d = Double.parseDouble(edttext.getText().toString());
                tvResult.setText( .016 * d + " CAD");
                break;

        }
    }



}
