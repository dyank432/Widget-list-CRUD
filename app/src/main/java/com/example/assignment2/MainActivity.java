package com.example.assignment2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

    public class MainActivity extends AppCompatActivity implements View.OnClickListener {
        RequestQueue requestQueue;
        TextView textView;

        String baseURL = "http://34.83.229.37:8080";


        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);
            findViewById(R.id.itemsButton).setOnClickListener(this);
            requestQueue = Volley.newRequestQueue(this);

             //String name = "";
//            getItembyName(name);
//
//            //hard coded for now
//            try {
//                addItem("Blah Blah", 50, 12.12);
//            } catch (JSONException e) {
//                e.printStackTrace();
//            }
        }

//        private void addItem(String name, int quantity, double price) throws JSONException {
//            //creating URL
////            String baseURL = "http://34.83.229.37:8080";
//            String route = "/api/items/";
//            String url = baseURL + route;
//
//            JSONObject newItem = null;
//
//            newItem = new JSONObject();
//            newItem.put("name", name);
//            newItem.put("quantity", quantity);
//            newItem.put("price", price);
//
//            JsonObjectRequest jRequest = new JsonObjectRequest(Request.Method.POST, url, newItem,
//                    new Response.Listener<JSONObject>() {
//                        @Override
//                        public void onResponse(JSONObject response) {
//
//                        }
//                    }, new Response.ErrorListener() {
//                @Override
//                public void onErrorResponse(VolleyError error) {
//                    Toast.makeText(MainActivity.this, "Something went wrong: " + error.getMessage(), Toast.LENGTH_LONG).show();
//                }
//            });
//            requestQueue.add(jRequest);
//        }
//
//        private void getItembyName(String name) {
////            String baseURL = "http://34.83.229.37:8080";
//            String route = "/api/items/?name="+name;
//            String url = baseURL + route;
//            JsonObjectRequest jRequest = new JsonObjectRequest(Request.Method.GET, url, null,
//                    new Response.Listener<JSONObject>() {
//                        @Override
//                        public void onResponse(JSONObject response) {
//                            try {
//                                //JSONObject  = (JSONObject) response.get("data");
//                                String name = (String) response.get("name");
//
////                                TextView textview = findViewById(R.id.itemsButton);
////                                textview.setText(name);
//
//                            } catch (JSONException e) {
//                                e.printStackTrace();
//                            }
//                        }
//                    }, new Response.ErrorListener() {
//                @Override
//                public void onErrorResponse(VolleyError error) {
//                    Toast.makeText(MainActivity.this, "Something went wrong: " + error.getMessage(), Toast.LENGTH_LONG).show();
//                }
//            });
//            requestQueue.add(jRequest);
//        }
//
//        private void getItembyId(String id) {
////            String baseURL = "http://34.83.229.37:8080";
//            String route = "/api/items/" + id;
//            String url = baseURL + route;
//            JsonObjectRequest jRequest = new JsonObjectRequest(Request.Method.GET, url, null,
//                    new Response.Listener<JSONObject>() {
//                        @Override
//                        public void onResponse(JSONObject response) {
//                            try {
//                                //JSONObject data = (JSONObject) response.get("data");
//                                String id = (String) response.get("id");
//
////                                TextView textview = findViewById(R.id.??);
////                                textview.setText(id);
//
//                            } catch (JSONException e) {
//                                e.printStackTrace();
//                            }
//                        }
//                    }, new Response.ErrorListener() {
//                @Override
//                public void onErrorResponse(VolleyError error) {
//                    Toast.makeText(MainActivity.this, "Something went wrong: " + error.getMessage(), Toast.LENGTH_LONG).show();
//                }
//            });
//            requestQueue.add(jRequest);
//        }

        @Override
        public void onClick(final View v) {
            if (v.getId() == R.id.itemsButton) {
                Intent items = new Intent(this, ItemPage.class);
                startActivity(items);
            }
            textView = findViewById(R.id.textView);
        }
    }


