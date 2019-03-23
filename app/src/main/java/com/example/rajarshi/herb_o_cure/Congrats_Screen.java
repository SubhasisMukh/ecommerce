package com.example.rajarshi.herb_o_cure;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class Congrats_Screen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_congrats__screen);
    }

    //lets go button clicked
    public void letsgoClicked(View view) {
        startActivity(new Intent(getApplicationContext(), MainActivity.class));
        this.finish();

    }
    //physical back button pressed
    @Override
    public void onBackPressed() {
        startActivity(new Intent(getApplicationContext(),MainActivity.class));
        super.onBackPressed();
        this.finish();
    }
}