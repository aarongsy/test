package com.example.mac.test;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by mac on 09/02/2016.
 */
public class Status extends ActionBarActivity {

       private TextView responseTextView;

        @Override
       protected void onCreate(Bundle savedInstanceState){
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_status);

            this.responseTextView = (TextView) this.findViewById(R.id.responseTextView);


        }



}
