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

        String baseURL = "REDACTED"; //example: http://0.0.0.0:8080


        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);
            findViewById(R.id.itemsButton).setOnClickListener(this);
            requestQueue = Volley.newRequestQueue(this);
        }

        @Override
        public void onClick(final View v) {
            if (v.getId() == R.id.itemsButton) {
                Intent items = new Intent(this, ItemPage.class);
                startActivity(items);
            }
            textView = findViewById(R.id.textView);
        }
    }


