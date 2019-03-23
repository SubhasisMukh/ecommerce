package com.example.rajarshi.herb_o_cure;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class My_cart extends AppCompatActivity {
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_cart);
        //ListView listView = (ListView) findViewById(R.id.listViewofmycart);
        //CustomadApterofCart customAdapter = new CustomadApterofCart();
        //listView.setAdapter(customAdapter);

    }


    ////back button pressed toolbar
    public void backBtnofcartClicked(View view) {
        this.finish();
    }




    //cart item show logic
    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        if(Product_home.countforcart>=1){
            TextView tv = (TextView) findViewById(R.id.cart_item_number);
            tv.setText("("+Product_home.countforcart+")");
            TextView tvforqty= (TextView) findViewById(R.id.qty);
            tvforqty.setText(""+Product_home.countforcart);

        }
    }

    public void ProceedToPaymentClicked(View view) {
        startActivity(new Intent(this,Payment.class));
        this.finish();
    }

    class CustomadApterofCart extends BaseAdapter {

        //list view methods ListView is "listViewofmycart" and single layout is single_cart_item
        @Override
        public int getCount() {
            return 0;
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
            v = getLayoutInflater().inflate(R.layout.single_cart_item, null);
            ImageView proimage = (ImageView) findViewById(R.id.product_pic_cart);
            TextView proname = (TextView) findViewById(R.id.product_namecart);
            TextView proprice = (TextView) findViewById(R.id.product_pricecart);
            proimage.setImageResource(R.drawable.a);
            proname.setText("Honey");
            proprice.setText("500");
            return v;
        }
    }
}
