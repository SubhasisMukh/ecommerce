package com.example.rajarshi.herb_o_cure;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

public class Payment extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);
    }

    public void backbtnPaymentClicked(View view) {
        this.finish();
    }

    @Override
    public void onBackPressed() {
        this.finish();
        super.onBackPressed();
    }

    public void continueOfPaymentClicked(View view) {
        Toast.makeText(this, "Order placed please check your E-mail.........", Toast.LENGTH_SHORT).show();
        this.finish();
        startActivity(new Intent(this, Congrats_order_paced.class));
    }
}
