package com.student.seagalputra.qualitycontrol;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {

    //Define variable for Product RecyclerView
    private List<Product> productList = new ArrayList<>();
    private RecyclerView recyclerView;
    private ProductAdapter pAdapter;
    private DividerItemDecoration dividerItemDecoration;

    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View home_fragment = inflater.inflate(R.layout.fragment_home, container, false);

        // Create List for Product
        recyclerView = (RecyclerView) home_fragment.findViewById(R.id.recyclerview_home);
        pAdapter = new ProductAdapter(productList);
        LinearLayoutManager pLayoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(pLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        // Add divider in RecyclerView
        dividerItemDecoration = new DividerItemDecoration(recyclerView.getContext(), pLayoutManager.getOrientation());
        recyclerView.addItemDecoration(dividerItemDecoration);

        // Set RecyclerView adapter
        recyclerView.setAdapter(pAdapter);

        prepareProductData();
        return home_fragment;
    }

    private void prepareProductData() {
        Product product = new Product("Swallow X", "Sepatu", "Rp 12.500");
        productList.add(product);

        product = new Product("Swallow Pro M1", "Sepatu", "Rp 1.100");
        productList.add(product);

        product = new Product("Prudential Shoes", "Sepatu", "Rp 1.000.000");
        productList.add(product);

        pAdapter.notifyDataSetChanged();
    }
}
