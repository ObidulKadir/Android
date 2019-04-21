import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.student.myapplication.R;

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
                function(view);
            }
        });
        btntrain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                function(view);
            }
        });
        btnbike.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                function(view);
            }
        });
        btncar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                function(view);
            }
        });

    }
    public void function(View view){
        switch(view.getId()){

            case R.id.btnbus:
                int cost=5;
               Double dist=Double.parseDouble(edttext.getText().toString());
                tvResult.setText(cost * dist+"");
                break;

            case R.id.btncar:
             cost=10;
              dist=Double.parseDouble(edttext.getText().toString());
                tvResult.setText(cost * dist+"");
                break;

            case R.id.btnbike:
                cost=15;
                dist=Double.parseDouble(edttext.getText().toString());
                tvResult.setText(cost * dist+"");
                break;

            case R.id.btntrain:
                cost=7;
                dist=Double.parseDouble(edttext.getText().toString());
                tvResult.setText(cost * dist+"");
                break;


        }


    }
}
