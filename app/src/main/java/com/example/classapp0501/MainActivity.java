package com.example.classapp0501;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.LinearLayout;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    List<DataList> lists;
    Myadaptor myadaptor;
    private String url = "http://servdoservice.com/api/rest/v1/categories.php";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.recyclerview);
        lists = new ArrayList<DataList>();

       // myadaptor = new Myadaptor(lists);
        RecyclerView.LayoutManager manager = new LinearLayoutManager(this);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(manager);
        //recyclerView.setAdapter(myadaptor);

        getData();
    }

    public void getData() {
        final ProgressDialog progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Loading");
        progressDialog.show();

        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {
                    Log.e("response",response.toString());
                    progressDialog.cancel();
                    JSONArray jsonArray = response.getJSONArray("CATEGORIES");

                    for (int i = 0; i < jsonArray.length(); i++) {
                        JSONObject categories = jsonArray.getJSONObject(i);
                        String id = categories.getString("categoryId");
                        String name = categories.getString("categoryName");
                        String description = categories.getString("categoryDescription");

                        lists.add(new DataList(id, name, description));

                    }
                    Log.e("Mainactivitylist",lists.get(0).getCategoryDescription().toString());
                    myadaptor = new Myadaptor(lists);
                    myadaptor.notifyDataSetChanged();
                    recyclerView.setAdapter(myadaptor);

                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                progressDialog.cancel();
                Log.e("Error",error.getMessage());


            }
        });

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(jsonObjectRequest);

    }
}
