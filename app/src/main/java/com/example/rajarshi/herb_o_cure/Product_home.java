package com.example.rajarshi.herb_o_cure;

import android.app.FragmentManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class Product_home extends AppCompatActivity {

    //product category items
    String[] product_cat_names = {"Ayurvedic Medicines", "Dietary Supplements", "Natural Remedies"};

    Context context;
    MySQLiteAdapter mySQLiteAdapter;
    Toolbar toolbar;
    ListView listView;
    Navigation_drawer_fragment drawer_fragment;
    public static int countforcart = 0;
    boolean doubleBackToExitPressedOnce = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_home);
        drawer_fragment = (Navigation_drawer_fragment) getSupportFragmentManager().findFragmentById(R.id.nav_drawer_fragment);
        drawer_fragment.setUp((DrawerLayout) findViewById(R.id.drawer_layout));
        setSupportActionBar(toolbar);
        listView = (ListView) findViewById(R.id.listviewofproducthome);
        listView.setTextAlignment(listView.TEXT_ALIGNMENT_CENTER);
        context = this;
        mySQLiteAdapter = new MySQLiteAdapter(context);

        ArrayAdapter<String> mAdapter = new ArrayAdapter<String>(Product_home.this, android.R.layout.simple_list_item_1, product_cat_names);

        //on select logic
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(Product_home.this, Product_list.class);
                intent.putExtra("ProductCategory", listView.getItemAtPosition(i).toString());
                startActivity(intent);

            }
        });
        listView.setAdapter(mAdapter);
    }


    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        if (MainActivity.checkguest == 0) {
            Bundle bundle = getIntent().getExtras();
            if (bundle != null) {

                String tempemail = bundle.getString("UserEmail");
                String Uname = mySQLiteAdapter.getUserNamefromEmail(tempemail);
                TextView tv = (TextView) findViewById(R.id.greetings_tv);
                tv.setText("Welcome \n" + Uname);
            }
        }
    }

    public void navbtnClicked(View view) {
        DrawerLayout mydrawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        mydrawer.openDrawer(Gravity.START);
    }


    public void cartClicked(View view) {

        if (MainActivity.checkguest == 0) {
            if (countforcart >= 1) {
                startActivity(new Intent(getApplicationContext(), My_cart.class));
            } else {
                startActivity(new Intent(getApplicationContext(), My_cart_empty.class));
            }
        } else {
            Toast.makeText(getApplicationContext(), "Sorry you are not Signed in", Toast.LENGTH_SHORT).show();
        }

    }


    @Override
    public void onBackPressed() {
        DrawerLayout mydrawer = (DrawerLayout) findViewById(R.id.drawer_layout);


        if (doubleBackToExitPressedOnce) {
            super.onBackPressed();
        }

        if (mydrawer.isDrawerOpen(Gravity.START)) {
            mydrawer.closeDrawers();

        } else {
            this.doubleBackToExitPressedOnce = true;
            Toast.makeText(this, "Press BACK again to exit", Toast.LENGTH_SHORT).show();
            new Handler().postDelayed(new Runnable() {

                @Override
                public void run() {
                    doubleBackToExitPressedOnce = false;
                }
            }, 2000);

        }


    }
}
