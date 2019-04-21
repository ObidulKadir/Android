package com.example.student.jsonparsing;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Adapter;
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
    HttpHandler httpHandler = new HttpHandler();
   final String url ="http://192.168.0.104/json.php";
   private String TAG = MainActivity.class.getSimpleName();
   private ListView lv;

   ArrayList<HashMap<String, String>> contactList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        contactList = new ArrayList<>();
        lv = (ListView) findViewById(R.id.lv);

        new GetContacts().execute();

    }
    private class GetContacts extends AsyncTask<Void, Void, Void > {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            Toast.makeText(MainActivity.this, "json is downloading", Toast.LENGTH_SHORT).show();
        }


        @Override
        protected Void doInBackground(Void... voids) {
            HttpHandler sh = new HttpHandler();
            String url = "http://192.168.0.104/json.php";
            String jsonStr = null;
            try {
                jsonStr = sh.makeServicecall(url);
            }catch (IOException e){
                e.printStackTrace();
            }
            Log.e (TAG, "Response from url: " +jsonStr);
            if (jsonStr != null){
                try{
                    JSONObject jsonobj = new JSONObject(jsonStr);
                    JSONArray student_info = jsonobj.getJSONArray("student_info");

                    for (int i = 0; i <student_info.length(); i++){
                        JSONObject c = student_info.getJSONObject(i);
                        String id = c.getString("s_id");
                        String name = c.getString("name");
                        String age = c.getString("age");
                        HashMap<String, String> contact = new HashMap<>();
                        contact.put("s_id", id);
                        contact.put("name", name);
                        contact.put("age",age);

                        contactList.add(contact);


                    }

                }catch (final JSONException e){
                    Log.e(TAG,"jsonparsing error: " + e.getMessage());
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            Toast.makeText(getApplicationContext(),"json parsing error: " + e.getMessage(),Toast.LENGTH_LONG).show();
                        }
                    });

                }
            }
            else{
                Log.e(TAG, "Couldn't get json from server.");
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(getApplicationContext(), "could't get json from server. check LogCat for possible errors!",
                                Toast.LENGTH_LONG).show();
                    }
                });
            }

            return null;
        }
        @Override
        protected void onPostExecute(Void result){
            super.onPostExecute(result);
            ListAdapter adapter =new SimpleAdapter(MainActivity.this,contactList,
                    R.layout.list_view, new String[]{ "s_id", "name", "age"},
                    new int[]{R.id.tv1, R.id.tv2, R.id.tv3 });
            lv.setAdapter(adapter);

        }
    }
}