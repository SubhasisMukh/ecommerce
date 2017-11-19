package com.example.rajarshi.herb_o_cure;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class Product_details extends AppCompatActivity {


    Toolbar mToolbar;
    ImageView productimage;
    TextView tv_for_product_name, tv_for_product_details, tv_for_product_price;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_details);

        productimage = (ImageView) findViewById(R.id.productimage);
        tv_for_product_name = (TextView) findViewById(R.id.product_nameof_deatils);
        tv_for_product_details = (TextView) findViewById(R.id.product_details_of_product_details);
        tv_for_product_price = (TextView) findViewById(R.id.product_pricefor_product_details);


//        Bundle bundle = getIntent().getExtras();
//        if (bundle != null) {
//
//            String productcategorytemp = bundle.getString("ProductCategory");
//
//            if (productcategorytemp.equals("Ayurvedic Medicines")) {
//
//
//            } else if (productcategorytemp.equals("Dietary Supplements")) {
//
//            } else if (productcategorytemp.equals("Natural Remedies")) {
//
//            }
//        }
    }


    public void backbtnforProdDetailsClicked(View view) {
        this.finish();
    }

    public void addtoCartClicked(View view) {


        if (MainActivity.checkguest == 0) {
            Product_home.countforcart += 1;
            Toast.makeText(this, "Item added to Cart.....", Toast.LENGTH_SHORT).show();

        } else {
            Toast.makeText(this, "Sorry you have to Sign in.....", Toast.LENGTH_SHORT).show();
        }


    }

    public void buyNowClicked(View view) {

        if (MainActivity.checkguest == 0) {
            this.finish();
            startActivity(new Intent(this, Payment.class));
        } else {
            Toast.makeText(this, "Sorry you have to Sign in.....", Toast.LENGTH_SHORT).show();
        }


    }

//
//    public void setterOfDetails(int image,String name,String details,String price){
//        productimage.setImageResource(image);
//        tv_for_product_name.setText(name);
//        tv_for_product_details.setText(details);
//        tv_for_product_price.setText(price);
//    }
}
