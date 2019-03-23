package com.example.rajarshi.herb_o_cure;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class My_cart_empty extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_cart_empty);
    }

    public void backbtnforemptycartClicked(View view) {
        this.finish();
    }

    @Override
    public void onBackPressed() {
        this.finish();
        super.onBackPressed();
    }

    public void continueShoppingClicked(View view) {
        startActivity(new Intent(getApplicationContext(),Product_home.class));
    }
}
