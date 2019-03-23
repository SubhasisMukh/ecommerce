package com.example.rajarshi.herb_o_cure;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class About_us extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_us);
    }

    public void backBtnofaboutusClicked(View view)
    {
        this.finish();
    }
}
