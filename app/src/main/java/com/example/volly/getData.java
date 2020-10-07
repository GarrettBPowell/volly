package com.example.volly;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.volly.dummy.myThing;
import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * An activity representing a list of Items. This activity
 * has different presentations for handset and tablet-size devices. On
 * handsets, the activity presents a list of items, which when touched,
 * lead to a {@link ItemDetailActivity} representing
 * item details. On tablets, the activity presents the list of items and
 * item details side-by-side using two vertical panes.
 */
public class getData
{
    private RequestQueue mQueue;
    public static HashMap<String, myThing> ITEM_MAP = null;
    public static List<myThing> PEOPLE = null;

    public void getDataFromURL(Context context)
    {
        if(PEOPLE != null)
            return;

        mQueue = Volley.newRequestQueue(context);

        parseJson(context);
        PEOPLE = new ArrayList<>();
        ITEM_MAP = new HashMap<>();
    }

    private void parseJson(final Context context)
    {
        String url = context.getString(R.string.myURL);
        final Gson gson = new Gson();

        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try
                        {
                            JSONArray jsonArray = response.getJSONArray("gameCompanies");

                            if(jsonArray.length() > 0)
                            {
                                List<myThing> companies = Arrays.asList(gson.fromJson(jsonArray.toString(), myThing[].class));

                                for(myThing company: companies)
                                    addToList(company);
                            }
                        }
                        catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
            }
        });
        mQueue.add(request);
    }

    public void addToList(myThing someCompany)
    {
        PEOPLE.add(someCompany);
        ITEM_MAP.put(someCompany.getName(), someCompany);
    }
}