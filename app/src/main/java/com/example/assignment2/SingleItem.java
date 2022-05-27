package com.example.assignment2;

import android.content.Intent;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.util.Log;
import android.view.Display;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.text.CollationElementIterator;
import java.util.ArrayList;

public class SingleItem extends AppCompatActivity {

    private LinearLayout linear;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.single_item_page);

        Bundle extras= getIntent().getExtras();


            TextView text = findViewById(R.id.itemDescription);
            text.setText(extras.getString("desc"));
            TextView text2 = findViewById(R.id.itemQuantity);
            text2.setText(extras.getString("quantity"));
            TextView text3 = findViewById(R.id.itemPrice);
            text3.setText(extras.getString("price"));
            TextView text4 = findViewById(R.id.itemId);
            text4.setText(extras.getString("id"));

    }
}