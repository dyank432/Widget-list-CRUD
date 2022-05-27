package com.example.assignment2;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.JsonRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class ItemPage extends AppCompatActivity {

    private LinearLayout linear;
    private Button add;
    private EditText itemID; // not used currently
    private EditText itemSearch;
    private EditText itemName;
    private EditText itemQuantity;
    private EditText itemCost;
    private ArrayList<Item> itemList = new ArrayList<Item>();
    private ListView list;
    private ArrayAdapter<Item> adapter;
    private RequestQueue requestQueue;


    private String baseURL = "REDACTED"; //example: http://0.0.0.0:8080


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_page);

        itemSearch = (EditText) findViewById(R.id.searchTerm); // added but unused
        itemName = (EditText) findViewById(R.id.itemName);
        itemQuantity = (EditText) findViewById(R.id.itemQuantity);
        itemCost = (EditText) findViewById(R.id.itemCost);

        Button search = (Button) findViewById(R.id.searchBtn);
        Button add = (Button) findViewById(R.id.addButton);
        list = (ListView) findViewById(R.id.list_view);

        requestQueue = Volley.newRequestQueue(this);

            String route = "/api/items/"; // endpoint for getting all items
            String url = baseURL + route;


        JsonArrayRequest jRequest = new JsonArrayRequest(Request.Method.GET, url, null,
                    new Response.Listener<JSONArray>() {
                        @Override
                        public void onResponse(JSONArray response) {
                            try {

                                for (int i = 0; i < response.length(); i++) {

                                    JSONObject obj = response.getJSONObject(i);
                                    int id = (Integer) obj.get("id");
                                    String name = (String) obj.get("name");
                                    String quantity = (String) obj.get("quantity");
                                    String price = (String) obj.get("price");
                                    Item item = new Item(""+id, name, quantity, price);
                                    itemList.add(item);
                                    adapter = new ArrayAdapter<Item>(getApplicationContext(), android.R.layout.simple_spinner_item, itemList);
                                    list.setAdapter(adapter);
                                }
                                for (Item item : itemList)
                                {
                                    Log.d("myTag", item.getId());
                                    Log.d("myTag", item.getDescription());
                                    Log.d("myTag", item.getQuantity());
                                    Log.d("myTag", item.getPrice());
                                }

                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }
                    }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    Toast.makeText(ItemPage.this, "Something went wrong: " + error.getMessage(), Toast.LENGTH_LONG).show();
                }
            });

        requestQueue.add(jRequest);



        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                setOnClick(view, itemList.get(position));
            }
        });
        add.setOnClickListener(new View.OnClickListener() {
                                   @Override
                                   public void onClick(View v) {

                                       String route = "/api/items/";
                                       String url = baseURL + route;

                                       Log.d("LIST SIZE", "" + itemList.size());
                                       String newItemId = "" + (itemList.size() + 1);
                                       String newItemName = String.valueOf(itemName.getText());
                                       String newItemQuantity = String.valueOf(itemQuantity.getText());
                                       String newItemCost = String.valueOf(itemCost.getText());

                                       JSONObject newItem = new JSONObject();
                                       try {
                                           newItem.put("name", newItemName);
                                           newItem.put("quantity", newItemQuantity);
                                           newItem.put("price", newItemCost);
                                           Log.d("LOG:", "newItem put reached");

                                       } catch (JSONException e) {
                                           e.printStackTrace();
                                           Log.d("LOG:", "DID NOT ADD ITEM");

                                       }

        JsonObjectRequest jRequest = new JsonObjectRequest(Request.Method.POST, url, newItem,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        Toast.makeText(ItemPage.this, "New Item added: " + newItemName + "," + newItemQuantity + "," + newItemCost, Toast.LENGTH_LONG).show();
                        Log.d("RESPONSE FROM ADD", "" + response.toString());
                        Item item = new Item(newItemId, newItemName, newItemQuantity, newItemCost);
                        itemList.add(item);
                        adapter = new ArrayAdapter<Item>(getApplicationContext(), android.R.layout.simple_spinner_item, itemList);
                        list.setAdapter(adapter);
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(ItemPage.this, "Something went wrong: " + error.getMessage(), Toast.LENGTH_LONG).show();
                Log.d("LOG:", "DID NOT ADD ITEM");

            }
        });

        requestQueue.add(jRequest);
        }

        });

        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for (Item item : itemList)
                {
                    if (item.getDescription().equalsIgnoreCase(String.valueOf(itemSearch.getText())))
                    {
                        Log.d("myTag", item.getDescription() + "~~~~FOUND");
                        Intent itemPass = new Intent(getApplicationContext(), SingleItem.class);
                        itemPass.putExtra("id", item.getId());
                        itemPass.putExtra("desc", item.getDescription());
                        itemPass.putExtra("quantity", item.getQuantity());
                        itemPass.putExtra("price", item.getPrice());
                        startActivity(itemPass);
                    }
                    else if (item.getId().equalsIgnoreCase(String.valueOf(itemSearch.getText())))
                    {
                        Log.d("myTag", item.getId() + "~~~~FOUND");
                        Intent itemPass = new Intent(getApplicationContext(), SingleItem.class);
                        itemPass.putExtra("id", item.getId());
                        itemPass.putExtra("desc", item.getDescription());
                        itemPass.putExtra("quantity", item.getQuantity());
                        itemPass.putExtra("price", item.getPrice());
                        startActivity(itemPass);
                    }
                }
            }
        });

    }

    private void setOnClick(final View v, final Item I){
        v.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent item = new Intent(getApplicationContext(), SingleItem.class);
                item.putExtra("id", I.getId());
                item.putExtra("desc", I.getDescription());
                item.putExtra("quantity", I.getQuantity());
                item.putExtra("price", I.getPrice());
                startActivity(item);
            }
        });
    }

}


