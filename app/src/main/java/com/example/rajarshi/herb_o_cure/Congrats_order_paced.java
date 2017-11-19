package com.example.rajarshi.herb_o_cure;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class Congrats_order_paced extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_congrats_order_paced);
    }





    @Override
    public void onBackPressed() {
        this.finish();
        startActivity(new Intent(this,Product_home.class));
        super.onBackPressed();
    }

    public void continueShppingOfOrderpacedSuccesfullyClicked(View view) {
        this.finish();
        startActivity(new Intent(this,Product_home.class));
        super.onBackPressed();
    }
}
