package com.example.rajarshi.herb_o_cure;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class Help_center extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_help_center);
    }

    public void backBtnforHelpCenterClicked(View view) {
        this.finish();
    }

    public void Dialer_Invoked(View view) {
        Intent intent = new Intent(Intent.ACTION_DIAL);
        intent.setData(Uri.parse("tel:(+880)88-02-9357052"));
        startActivity(intent);
    }

    public void Email_invoke(View view) {
        Intent intent = new Intent(Intent.ACTION_VIEW);
        Uri data = Uri.parse("mailto:info@modernherbal.org");
        intent.setData(data);
        startActivity(intent);
    }
}
