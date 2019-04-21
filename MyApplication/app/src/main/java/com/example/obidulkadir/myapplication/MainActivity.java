package com.example.obidulkadir.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    Button btn1,btn2,btn3,btn4,btn5,btn6,btn7,btn8,btn9,btn0,btnadd,btnmul,btnsub,btndiv,btnequal,btnclear;
    Double val1,val2;
    boolean add,mul,div,sub;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final TextView output = (TextView) findViewById(R.id.tvResult);
        btn1= (Button) findViewById(R.id.btn1);
        btn2= (Button) findViewById(R.id.btn2);
        btn3= (Button) findViewById(R.id.btn3);
        btn4= (Button) findViewById(R.id.btn4);
        btn5= (Button) findViewById(R.id.btn5);
        btn6= (Button) findViewById(R.id.btn6);
        btn7= (Button) findViewById(R.id.btn7);
        btn8= (Button) findViewById(R.id.btn8);
        btn9= (Button) findViewById(R.id.btn9);
        btn0= (Button) findViewById(R.id.btn0);
        btnadd=(Button) findViewById(R.id.btnadd);
        btnsub=(Button) findViewById(R.id.btnsub);
        btnmul=(Button) findViewById(R.id.btnmul);
        btndiv=(Button) findViewById(R.id.btndiv);

        btnequal=(Button) findViewById(R.id.btnequal);
        btnclear=(Button) findViewById(R.id.btnclear);

        btn0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                output.setText(output.getText()+"0");
            }

        });
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                output.setText(output.getText()+"1");
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                output.setText(output.getText()+"2");
            }
        });
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                output.setText(output.getText()+"3");
            }
        });
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                output.setText(output.getText()+"4");
            }
        });
        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                output.setText(output.getText()+"5");
            }
        });
        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                output.setText(output.getText()+"6");
            }
        });
        btn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                output.setText(output.getText()+"7");
            }
        });
        btn8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                output.setText(output.getText()+"8");
            }
        });
        btn9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                output.setText(output.getText()+"9");
            }
        });

        btnclear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                output.setText("");
            }
        });
        btnadd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try{
                    val1=Double.parseDouble(output.getText().toString());
                    output.setText(null);
                    add=true;
                }catch (Exception e){
            }}
        });

                btnsub.setOnClickListener(new View.OnClickListener() {

                    @Override
                    public void onClick(View view) {
                        try {
                            val1 = Double.parseDouble(output.getText().toString());
                            output.setText(null);
                            sub = true;
                        }catch (Exception e){}
                    }
                });
                btnmul.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        try{
                            val1=Double.parseDouble(output.getText().toString());
                            output.setText(null);
                            mul=true;

                        }catch (Exception e){}
                    }
                });

                btndiv.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        try{
                            val1=Double.parseDouble(output.getText().toString());
                            output.setText(null);
                            div=true;

                        }catch (Exception e){}
                    }
                });

                btnequal.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        try{
                            val2=Double.parseDouble(output.getText().toString());
                            if(add == true){
                                output.setText(val1 + val2+"");
                                add=false;
                            }
                            if(sub == true){
                                output.setText(val1 - val2 +"");
                                sub=false;
                            }
                            if (mul == true){
                                output.setText(val1 * val2 +"");
                                mul=false;
                            }
                            if(div == true){
                                output.setText(val1 / val2 +"");
                                div=false;
                            }
                        }catch (Exception e){

                        }
                    }
                });

    }
}
