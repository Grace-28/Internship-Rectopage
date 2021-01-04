package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    ListView listview;
    ArrayList<String> arrayList = new ArrayList<>();
    ArrayList<String> optionList = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listview=(ListView)findViewById(R.id.listview);
        ArrayAdapter arrayAdapter= new ArrayAdapter(this,android.R.layout.simple_list_item_1,arrayList);
        listview.setAdapter(arrayAdapter);
        get_json();
    }
    public void get_json()
    {
        String json;
        try
        {
            InputStream is = getAssets().open("task4.json");
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();

            json = new String(buffer, "UTF-8");
            JSONArray jsonArray = new JSONArray(json);

            for(int i=0; i<jsonArray.length();i++)
            {
                JSONObject obj =jsonArray.getJSONObject(i);
                //if(obj.getString("question_number").equals("j++"))
               // {
                    arrayList.add(obj.getString("question"));

                //}
            }//Toast.makeText(getApplicationContext(),arrayList.toString(),Toast.LENGTH_LONG).show();

        }catch (IOException e)
        {
            e.printStackTrace();
        }catch (JSONException e)
        {
            e.printStackTrace();
        }
    }
}