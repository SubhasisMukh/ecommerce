package com.example.rajarshi.herb_o_cure;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class My_Orders extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my__orders);
    }

    public void backbtnofmyordersClicked(View view) {
        this.finish();
    }
}
