package com.example.obidulkadir.jsonparsingapp;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    private  String TAG = MainActivity.class.getSimpleName();
    private ListView lv;

    ArrayList<HashMap<String, String>> contactlist;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        contactlist = new ArrayList<>();
        lv = (ListView) findViewById(R.id.list);

        new  GetContacts().execute();
    }
    private class GetContacts extends AsyncTask<Void,Void,Void>{

        @Override
        protected void onPreExecute(){
            super.onPreExecute();
            Toast.makeText(MainActivity.this,"Json data is downloading...",Toast.LENGTH_LONG).show();
        }
        @Override
        protected Void doInBackground(Void... voids) {
            HttpHandler sh = new HttpHandler();

            String url = "http://172.17.0.108:8080/json/json.php";
            String jsonStr = null;

            try {
                jsonStr = sh.makeServiceCall(url);
            }catch (IOException e){
                e.printStackTrace();
            }
            Log.e(TAG,"Response from url:" + jsonStr);
            if(jsonStr != null){
                try{
                    JSONObject jsonObJ = new JSONObject(jsonStr);

                    JSONArray students = jsonObJ.getJSONArray("students");

                    for (int i = 0;i<students.length();i++){
                        JSONObject c = students.getJSONObject(i);
                        String s_id = c.getString("s_id");
                        String name = c.getString("name");
                        String age = c.getString("age");


                        HashMap<String, String> contact = new HashMap<>();

                        contact.put("s_id", s_id);
                        contact.put("name", name);
                        contact.put("age", age);
                        contactlist.add(contact);
                    }
                } catch (final JSONException e) {
                    Log.e(TAG, "Json parsing error: " + e.getMessage());
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            Toast.makeText(getApplicationContext(),
                                    "Json parsing error: " + e.getMessage(),
                                    Toast.LENGTH_LONG).show();
                        }
                    });

                }

            } else {
                Log.e(TAG, "Couldn't get json from server.");
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(getApplicationContext(),
                                "Couldn't get json from server. Check LogCat for possible errors!",
                                Toast.LENGTH_LONG).show();
                    }
                });
            }

            return null;
        }

        @Override
        protected void onPostExecute(Void result) {
            super.onPostExecute(result);
            ListAdapter adapter = new SimpleAdapter(MainActivity.this, contactlist,
                    R.layout.list_view, new String[]{ "s_id","name","age"},
                    new int[]{R.id.id,R.id.name, R.id.age});
            lv.setAdapter(adapter);
        }
    }
}