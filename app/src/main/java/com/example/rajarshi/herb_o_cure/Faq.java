package com.example.rajarshi.herb_o_cure;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class Faq extends AppCompatActivity {


    ListView listView;
    String questionarray[]={"What is Herb-&-Cure?", "Why Herb-&-Cure?", "Where is Herb-&-Cure?"};

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_faq);

        listView = (ListView)findViewById(R.id.faqlistview);
        FaqSetterAdapter customAdopter = new FaqSetterAdapter();
        listView.setAdapter(customAdopter);

    }

    public void backbtnFaqClicked(View view) {
        this.finish();
    }

    class FaqSetterAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return questionarray.length;
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View v, ViewGroup parent) {
            v = getLayoutInflater().inflate(R.layout.single_faq_layout, null);
            TextView textView_name = (TextView) v.findViewById(R.id.faqsingleitemtextview);
            textView_name.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
            textView_name.setText(questionarray[position]);
            return v;
        }
    }
}

