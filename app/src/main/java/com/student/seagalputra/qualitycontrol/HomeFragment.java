package com.student.seagalputra.qualitycontrol;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.ListFragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONStringer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {

    //Define variable for Product RecyclerView
    private List<Product> productList = new ArrayList<>();
    //private RecyclerView recyclerView;
    //private ProductAdapter pAdapter;
    //private DividerItemDecoration dividerItemDecoration;
    private ListView listView;
    private String JSON_STRING;

    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View home_fragment = inflater.inflate(R.layout.fragment_home, container, false);

        // Create List for Product
        //recyclerView = (RecyclerView) home_fragment.findViewById(R.id.recyclerview_home);
        //pAdapter = new ProductAdapter(productList);
        //LinearLayoutManager pLayoutManager = new LinearLayoutManager(getActivity());
        //recyclerView.setLayoutManager(pLayoutManager);
        //recyclerView.setItemAnimator(new DefaultItemAnimator());

        // Add divider in RecyclerView
        //dividerItemDecoration = new DividerItemDecoration(recyclerView.getContext(), pLayoutManager.getOrientation());
        //recyclerView.addItemDecoration(dividerItemDecoration);

        // Set RecyclerView adapter
        //recyclerView.setAdapter(pAdapter);

        //prepareProductData();
        //listView = (ListView) getContext().findViewById(R.id.listView);
        listView = (ListView) getActivity().findViewById(R.id.listView);
        // listView.setOnClickListener(this);
        getJSON();

        return home_fragment;
    }

    private void showProduct() {
        JSONObject jsonObject = null;
        ArrayList<HashMap<String, String>> list = new ArrayList<HashMap<String, String>>();
        try {
            jsonObject = new JSONObject(JSON_STRING);
            JSONArray result = jsonObject.getJSONArray(Server.TAG_JSON_ARRAY);

            for (int i = 0; i < result.length(); i++) {
                JSONObject jo = result.getJSONObject(i);
                String nameProduct = jo.getString(Server.TAG_JSON_PRODUCT_NAME);
                String priceProduct = jo.getString(Server.TAG_JSON_PRODUCT_SELL_PRICE);

                HashMap<String, String> product = new HashMap<>();
                product.put(Server.TAG_JSON_PRODUCT_NAME,nameProduct);
                product.put(Server.TAG_JSON_PRODUCT_SELL_PRICE, priceProduct);
                list.add(product);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }

        ListAdapter adapter = new SimpleAdapter(
                getContext(), list, R.layout.fragment_home, new String[]{Server.TAG_JSON_PRODUCT_ID, Server.TAG_JSON_PRODUCT_NAME}, new int[]{R.id.name_product, R.id.price_product});
    }

    private void getJSON() {

    }

    /*
    private void prepareProductData() {
        Product product = new Product("Swallow X", "Sepatu", "Rp 12.500");
        productList.add(product);

        product = new Product("Swallow Pro M1", "Sepatu", "Rp 1.100");
        productList.add(product);

        product = new Product("Prudential Shoes", "Sepatu", "Rp 1.000.000");
        productList.add(product);

        pAdapter.notifyDataSetChanged();
    } **/
}
