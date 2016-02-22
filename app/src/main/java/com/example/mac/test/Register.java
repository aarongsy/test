package com.example.mac.test;

/**
 * Created by mac on 10/02/2016.
 */
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Request.Method;
import com.android.volley.AuthFailureError;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class Register extends ActionBarActivity {

    private JSONObject params;
    private RequestQueue queue;
    private final String REQUEST_URL = "https://www.nappyzap.com/androidInterface/checkLogin.php";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        queue = Volley.newRequestQueue(getApplicationContext());

        Button btn = (Button)findViewById(R.id.buttonregister);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                //get input email and password
                EditText email = (EditText)findViewById(R.id.editemailAddress);
                EditText pass = (EditText)findViewById(R.id.editpassword);
                setLogin(String.valueOf(email.getText()), String.valueOf(pass.getText()), getApplicationContext());

            }
        });
        Button btn2 = (Button)findViewById(R.id.buttonhome);

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Register.this, Home.class));
            }
        });
    }

    public void setLogin(String emailAddress, String password, Context ctx) {
        JSONObject params = new JSONObject();
        try {
            params.put("emailAddress", emailAddress);
            params.put("password", password);
        }
        catch (JSONException e){
            e.printStackTrace();
        }
        //Add to your request queue here.
        Log.d("login", "Request Sent");
        queue.add(getJsonObject(getApplicationContext(), params));
    }

    private synchronized JsonObjectRequest getJsonObject(final Context ctx, JSONObject params){
        JsonObjectRequest ret = new JsonObjectRequest
                (Request.Method.POST, REQUEST_URL, params, new Response.Listener<JSONObject>() {

                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            Log.d("Login", "Response Received");
                            UserData user = UserData.getInstance();
                            user.setID(response.getInt("userID"));
                            user.setEmail(response.getString("emailAddress"));
                            user.setFirstName(response.getString("firstName"));
                            user.setLastName(response.getString("lastName"));
                            user.setPhoneNo(response.getString("phoneNo"));
                            user.setHouseNo(response.getString("houseNo"));
                            user.setBinLocation(response.getString("binLocation"));
                            user.setCity(response.getString("city"));
                            user.setStreet(response.getString("street"));
                            user.setCounty(response.getString("county"));
                            user.setPostcode(response.getString("postcode"));
                            startActivity(new Intent(Register.this, Dashboard.class));
                            //Correct Handling code right here
                        }
                        catch (JSONException e){
                            e.printStackTrace();
                            //Toast.makeText(, "Login incorrect", Toast.LENGTH_LONG);
                        }
                    }
                }, new Response.ErrorListener() {

                    @Override
                    public void onErrorResponse(VolleyError error) {
                        //Incorrect handling
                        Log.d("Login", "onErrorResponse: " + error.getMessage());
                    }
                }){
            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                Map<String,String> headers = new HashMap<String, String>();
                headers.put("Content-Type","application/json; charset=utf-8");
                headers.put("User-agent", "My useragent");
                return headers;
            }
        };
        return ret;
    }
}
