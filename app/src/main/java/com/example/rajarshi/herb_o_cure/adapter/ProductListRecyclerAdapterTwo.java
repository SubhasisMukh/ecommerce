package com.example.rajarshi.herb_o_cure.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.rajarshi.herb_o_cure.Product_details;
import com.example.rajarshi.herb_o_cure.R;
import com.example.rajarshi.herb_o_cure.product_model.Category_one;
import com.example.rajarshi.herb_o_cure.product_model.Category_two;

import java.util.List;

/**
 * Created by Rajarshi on 7/24/2017.
 */

public class ProductListRecyclerAdapterTwo extends RecyclerView.Adapter<ProductListRecyclerAdapterTwo.MyViewHolder> {
    private List<Category_two> mdata;
    private LayoutInflater mInflater;
    Context ctx;

    public ProductListRecyclerAdapterTwo(Context context, List<Category_two> data) {
        this.mdata = data;
        this.mInflater = LayoutInflater.from(context);
        this.ctx=context;
    }


    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.single_product_list_item, parent, false);
        MyViewHolder holder = new MyViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Category_two currentObj = mdata.get(position);
        holder.setData(currentObj, position);
    }

    @Override
    public int getItemCount() {
        return mdata.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView pro_name,pro_des,pro_price;
        ImageView pro_image;
        int position;
        Category_two current;

        public MyViewHolder(View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
            pro_name = (TextView) itemView.findViewById(R.id.product_name_oflist);
            pro_des = (TextView) itemView.findViewById(R.id.product_des_oflist);
            pro_price = (TextView) itemView.findViewById(R.id.product_price_oflist);
            pro_image = (ImageView) itemView.findViewById(R.id.product_image_oflist);
        }

        public void setData(Category_two current, int position) {

            this.pro_image.setImageResource(current.getImageID());
            this.pro_name.setText(current.getProduct_name());
            this.pro_des.setText(current.getDescription());
            this.pro_price.setText(""+current.getProduct_price());
            this.position = position;
            this.current=current;
        }

        @Override
        public void onClick(View v) {
            Category_two cattwo = mdata.get(position);

            Intent intent = new Intent(ctx, Product_details.class);

            intent.putExtra("prodimage", cattwo.getImageID());
            intent.putExtra("prodname", cattwo.getProduct_name());
            intent.putExtra("proddes", cattwo.getDescription());
            intent.putExtra("prodprice", cattwo.getProduct_price());
            ctx.startActivity(intent);
        }
    }
}
