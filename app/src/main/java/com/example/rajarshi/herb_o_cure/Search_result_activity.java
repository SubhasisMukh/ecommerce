package com.example.rajarshi.herb_o_cure;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class Search_result_activity extends AppCompatActivity {
    TextView textviewforsearch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        textviewforsearch = (TextView) findViewById(R.id.results);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_result_activity);
        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            String search_string = bundle.getString("searchstrings");
            textviewforsearch.setText(search_string);

        }
    }

    public void backbtnforSearchResultsClicked(View view) {
        this.finish();
    }
}
