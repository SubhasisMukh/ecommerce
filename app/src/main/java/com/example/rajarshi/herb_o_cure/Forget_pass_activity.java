package com.example.rajarshi.herb_o_cure;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

public class Forget_pass_activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forget_pass_activity);
    }

    public void passResetClicked(View view) {
        Toast.makeText(this, "Please Check your E-Mail for reset link it will help you to reset your password", Toast.LENGTH_LONG).show();
        this.finish();
    }

    public void backbtnforForgetPassClicked(View view) {
        this.finish();
    }
}
