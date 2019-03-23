package com.example.rajarshi.herb_o_cure;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Context context;
    MySQLiteAdapter mySQLiteAdapter;
    public static EditText ed1, ed2;
    public static int checkguest;
    boolean doubleBackToExitPressedOnce = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ed1 = (EditText) findViewById(R.id.email);
        ed2 = (EditText) findViewById(R.id.user_password);
        context = this;
        mySQLiteAdapter = new MySQLiteAdapter(context);

    }


    @Override
    protected void onDestroy() {
        My_account.tempusr_name = ed1.getText().toString();
        super.onDestroy();
    }


    public void registerClicked(View view) {
        startActivity(new Intent(getApplicationContext(), SignUpactivity.class));
        this.finish();
    }

    public void skipClicked(View view) {
        Toast.makeText(this, "You are logged in as Guest please sign in...", Toast.LENGTH_SHORT).show();
        checkguest = 1;
        this.finish();
        startActivity(new Intent(getApplicationContext(), Product_home.class));
    }

    public void signInClicked(View view) {


        checkguest = 0;
        String strname, strpass;
        strname = ed1.getText().toString();
        strpass = ed2.getText().toString();

        String stored_pass = mySQLiteAdapter.getSingleEntry(strname);


        if (strname.isEmpty()) {

            Toast.makeText(this, "Please Enter your E-Mail.....", Toast.LENGTH_SHORT).show();

        } else if (strpass.isEmpty()) {
            Toast.makeText(this, "Please Enter your Password.....", Toast.LENGTH_SHORT).show();

        } else {
            if (strpass.equals(stored_pass)) {
                Intent intent = new Intent(MainActivity.this, Product_home.class);
                intent.putExtra("UserEmail", ed1.getText().toString());
                startActivity(intent);

                //assigning guest name
                String tempname = mySQLiteAdapter.getUserNamefromEmail(strname);
                Toast.makeText(this, "Welcome to Herb-&-Cure: " + tempname, Toast.LENGTH_LONG).show();
                this.finish();
            } else {
                Toast.makeText(getApplicationContext(), "Wrong password or username......", Toast.LENGTH_SHORT).show();
            }
        }
    }

    public void forgetPassClicked(View view) {
        startActivity(new Intent(getApplicationContext(), Forget_pass_activity.class));
    }


    @Override
    public void onBackPressed() {
        DrawerLayout mydrawer = (DrawerLayout) findViewById(R.id.drawer_layout);


        if (doubleBackToExitPressedOnce) {
            super.onBackPressed();
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

