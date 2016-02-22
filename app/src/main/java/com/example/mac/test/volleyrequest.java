package com.example.mac.test;

import android.os.Bundle;
import android.widget.TextView;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.android.volley.Request;

/**
 * Created by mac on 19/02/2016.
 */
/*
public class volleyrequest extends ActionBarActivity {
    private TextView responseTextView;
    public final String REDDIT_URL="http://www.reddit.com/r/all.json?limit=5";

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_status);
        this.responseTextView = (TextView) this.findViewById(R.id.responseTextView);

        //
        RequestQueue queue = Volley.newRequestQueue(this);
        //String url=REDDIT_URL;

        StringRequest request = new StringRequest(com.android.volley.Request.Method.GET,REDDIT_URL, new Response.Listener<String>(){
            @Override
            public void onResponse(String response){
                this.responseTextView.setText("Response is: " + response.substring(0,500));
            }
        }, new Response.ErrorListener(){
            @Override
            public void onErrorResponse(VolleyError error){
                //error happens
            }
        });
        //
        queue.add(request);

    }
}

*/