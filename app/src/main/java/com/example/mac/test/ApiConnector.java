package com.example.mac.test;

import android.util.Log;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONException;

import java.io.IOException;

/**
 * Created by mac on 19/02/2016.
 */
public class ApiConnector {

   public JSONArray GetAllCustomers(){
       //url
       String url = "https://www.nappyzap.com/androidInterface/login.php";

       //Get http responce Object from url
       //Get httpEntity from http responseobject
       HttpEntity httpEntity = null;

       try
       {
           DefaultHttpClient httpClient = new DefaultHttpClient();
           HttpGet httpGet = new HttpGet(url);

           HttpResponse httpResponse = httpClient.execute(httpGet);
           httpEntity= httpResponse.getEntity();

       }catch ( ClientProtocolException e){
           //signals error in http protocol
           e.printStackTrace();
           //log Errors here
       }catch (IOException e){
           e.printStackTrace();
       }
       //convert httpentity into JSON Array
       JSONArray jsonArray = null;

       if (httpEntity != null){
           try{
               String entityResponse = EntityUtils.toString(httpEntity);

               Log.e("Entity Response :", entityResponse);

               jsonArray = new JSONArray(entityResponse);

           }catch(JSONException e){
               e.printStackTrace();
           }catch (IOException e){
               e.printStackTrace();
           }
       }
       return jsonArray;
   }
}
