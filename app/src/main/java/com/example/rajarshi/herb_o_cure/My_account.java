package com.example.rajarshi.herb_o_cure;

import android.app.AlertDialog;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

public class My_account extends AppCompatActivity {
    EditText usrname_fordatabase_query;
    static public String tempusr_name;
    Context context;
    MySQLiteAdapter mySQLiteAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_account);

        context = this;
        mySQLiteAdapter = new MySQLiteAdapter(context);
    }

    public void backbtnforMyaccountClicked(View view) {
        this.finish();
    }


    public void detailsClicked(View view) {

        try {
            String allrecords = mySQLiteAdapter.DisplayAllRecords(tempusr_name);
            showMessage("Keep it Secret!", allrecords);
        } catch (Exception e) {

        }

    }

    public void showMessage(String title, String Message) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(Message);
        builder.show();
    }
}
