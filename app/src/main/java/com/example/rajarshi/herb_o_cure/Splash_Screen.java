package com.example.rajarshi.herb_o_cure;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class Splash_Screen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash__screen);
        Thread mythread = new Thread() {

            @Override
            public void run() {
                try {
                    sleep(3000);
                    Intent myintent = new Intent(getApplicationContext(), MainActivity.class);
                    startActivity(myintent);
                    finish();

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        mythread.start();
    }
}
