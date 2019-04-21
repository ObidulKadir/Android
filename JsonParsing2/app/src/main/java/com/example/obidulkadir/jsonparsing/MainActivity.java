package com.example.obidulkadir.jsonparsing;

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

    ListView listView;
    HttpHandler httpHandler = new  HttpHandler();
    final String url = "http://192.168.0.104/json/json.php";
    //private String TAG = MainActivity.class.getSimpleName();
    private ListView lv;

    ArrayList<HashMap<String, String>> data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.lv);
        data = new ArrayList<>();
        new GetContacts().execute();

    }
    private class GetContacts extends AsyncTask<Void, Void, Void > {

        @Override
        protected Void doInBackground(Void... voids) {
            HttpHandler httpHelper = new HttpHandler();
            String url = "http://192.168.0.104/json/json.php";
            String jsonString = null;
            try {
                jsonString = httpHelper.makeServicecall(url);
            } catch (IOException e) {
                e.printStackTrace();
            }
            Log.e("GEtContacts", "response from url: " + jsonString);

            if (jsonString != null) {
                try {
                    JSONObject object = new JSONObject(jsonString);
                    JSONArray student_info = object.getJSONArray("student_info");

                    for (int i = 0; i < student_info.length(); i++) {
                        JSONObject jsonObject = student_info.getJSONObject(i);
                        String s_id = jsonObject.getString("s_id");
                        String name = jsonObject.getString("name");
                        String age = jsonObject.getString("age");

                        HashMap<String, String> contacts = new HashMap<>();
                        contacts.put("s_id",s_id);
                        contacts.put("name",name);
                        contacts.put("age",age);

                        Log.e("Json Data:", "Json Data: " + s_id+" "+name+" "+age);


                        data.add(contacts);
                    }

                } catch (final JSONException e) {

                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            Toast.makeText(MainActivity.this, "JSON parse error: "+e.getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    });
                }
            }else {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(MainActivity.this, "Couldn't get Json Data", Toast.LENGTH_SHORT).show();

                    }
                });
            }

            return null;
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            Toast.makeText(MainActivity.this, "Loading...", Toast.LENGTH_SHORT).show();
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            ListAdapter adapter=new SimpleAdapter(MainActivity.this,data, R.layout.list_view, new String[]{ "s_id", "name", "age"},
                    new int[]{R.id.tv1, R.id.tv2, R.id.tv3 });
            listView.setAdapter(adapter);

            super.onPostExecute(aVoid);
        }
    }
}