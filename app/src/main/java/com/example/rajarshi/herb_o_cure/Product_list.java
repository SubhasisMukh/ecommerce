package com.example.rajarshi.herb_o_cure;

import android.os.Bundle;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.example.rajarshi.herb_o_cure.adapter.ProductListRecyclerAdapterOne;
import com.example.rajarshi.herb_o_cure.adapter.ProductListRecyclerAdapterThree;
import com.example.rajarshi.herb_o_cure.adapter.ProductListRecyclerAdapterTwo;
import com.example.rajarshi.herb_o_cure.product_model.Category_one;
import com.example.rajarshi.herb_o_cure.product_model.Category_three;
import com.example.rajarshi.herb_o_cure.product_model.Category_two;

import java.util.ArrayList;

public class Product_list extends AppCompatActivity implements SearchView.OnQueryTextListener {
    Toolbar toolbar;
    ArrayList<Category_one> arrayListone = new ArrayList<>();
    ArrayList<Category_two> arrayListtwo = new ArrayList<>();
    ArrayList<Category_three> arrayListthree = new ArrayList<>();
    ProductListRecyclerAdapterOne adapterOne;
    ProductListRecyclerAdapterTwo adapterTwo;
    ProductListRecyclerAdapterThree adapterThree;

    Bundle bundle;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_list);

        bundle = getIntent().getExtras();
        if (bundle != null) {

            String productcategorytemp = bundle.getString("ProductCategory");

            if (productcategorytemp.equals("Ayurvedic Medicines")) {
                setUpRecyclerViewforCat1();
                arrayListone = Category_one.getData();

            } else if (productcategorytemp.equals("Dietary Supplements")) {
                setUpRecyclerViewforCat2();
                arrayListtwo = Category_two.getData();
            } else if (productcategorytemp.equals("Natural Remedies")) {
                setUpRecyclerViewforCat3();
                arrayListthree = Category_three.getData();

            }
        }
        toolbar = (Toolbar) findViewById(R.id.toolbarforproductlist);
        setSupportActionBar(toolbar);
        toolbar.inflateMenu(R.menu.menu_items);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_items, menu);
        MenuItem menuItem = menu.findItem(R.id.action_search);
        SearchView searchView = (SearchView) MenuItemCompat.getActionView(menuItem);
        searchView.setOnQueryTextListener(this);
        return true;
    }

    private void setUpRecyclerViewforCat1() {

        //Local reference and setup adapter
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycler_for_product_list);
        adapterOne = new ProductListRecyclerAdapterOne(this, Category_one.getData());
        recyclerView.setAdapter(adapterOne);


        //orientation of Recycler View
        LinearLayoutManager mlinearLayoutManager = new LinearLayoutManager(this);
        mlinearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(mlinearLayoutManager);

        //providing animation
        recyclerView.setItemAnimator(new DefaultItemAnimator());


    }

    private void setUpRecyclerViewforCat2() {

        //Local reference and setup adapter
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycler_for_product_list);
        adapterTwo = new ProductListRecyclerAdapterTwo(this, Category_two.getData());
        recyclerView.setAdapter(adapterTwo);


        //orientation of Recycler View
        LinearLayoutManager mlinearLayoutManager = new LinearLayoutManager(this);
        mlinearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(mlinearLayoutManager);

        //providing animation
        recyclerView.setItemAnimator(new DefaultItemAnimator());


    }

    private void setUpRecyclerViewforCat3() {

        //Local reference and setup adapter
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycler_for_product_list);
        adapterThree = new ProductListRecyclerAdapterThree(this, Category_three.getData());
        recyclerView.setAdapter(adapterThree);


        //orientation of Recycler View
        LinearLayoutManager mlinearLayoutManager = new LinearLayoutManager(this);
        mlinearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(mlinearLayoutManager);

        //providing animation
        recyclerView.setItemAnimator(new DefaultItemAnimator());


    }

    public void backbtnforProductListClicked(View view) {
        this.finish();
    }


    @Override
    public boolean onQueryTextSubmit(String query) {
        return false;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        newText = newText.toLowerCase();


        if (bundle != null) {

            String productcategorytemp = bundle.getString("ProductCategory");

            if (productcategorytemp.equals("Ayurvedic Medicines")) {
                ArrayList<Category_one> newlist = new ArrayList<>();

                for (Category_one category_one : arrayListone) {
                    String name = category_one.getProduct_name().toString();

                    if (name.toLowerCase().contains(newText)) {

                        newlist.add(category_one);
                    }
                }

                adapterOne.setFilter(newlist);


            } else if (productcategorytemp.equals("Dietary Supplements")) {
                ArrayList<Category_two> newlist = new ArrayList<>();

                for (Category_two category_two : arrayListtwo) {
                    String name = category_two.getProduct_name().toString();

                    if (name.toLowerCase().contains(newText)) {

                        newlist.add(category_two);
                    }
                }

                adapterTwo.setFilter(newlist);


            } else if (productcategorytemp.equals("Natural Remedies")) {

                ArrayList<Category_three> newlist = new ArrayList<>();

                for (Category_three category_three : arrayListthree) {
                    String name = category_three.getProduct_name().toString();

                    if (name.toLowerCase().contains(newText)) {

                        newlist.add(category_three);
                    }
                }

                adapterThree.setFilter(newlist);


            }
        }

        return true;
    }
}
