package com.example.rajarshi.herb_o_cure.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.rajarshi.herb_o_cure.R;
import com.example.rajarshi.herb_o_cure.product_model.Category_three;

import java.util.List;

/**
 * Created by Rajarshi on 7/24/2017.
 */

public class ProductListRecyclerAdapterThree extends RecyclerView.Adapter<ProductListRecyclerAdapterThree.MyViewHolder> {
    private List<Category_three> mdata;
    private LayoutInflater mInflater;

    public ProductListRecyclerAdapterThree(Context context, List<Category_three> data) {
        this.mdata = data;
        this.mInflater = LayoutInflater.from(context);
    }


    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.single_product_list_item, parent, false);
        MyViewHolder holder = new MyViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Category_three currentObj = mdata.get(position);
        holder.setData(currentObj, position);
    }

    @Override
    public int getItemCount() {
        return mdata.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        TextView pro_name,pro_des,pro_price;
        ImageView pro_image;
        int position;
        Category_three current;

        public MyViewHolder(View itemView) {
            super(itemView);
            pro_name = (TextView) itemView.findViewById(R.id.product_name_oflist);
            pro_des = (TextView) itemView.findViewById(R.id.product_des_oflist);
            pro_price = (TextView) itemView.findViewById(R.id.product_price_oflist);
            pro_image = (ImageView) itemView.findViewById(R.id.product_image_oflist);
        }

        public void setData(Category_three current, int position) {

            this.pro_image.setImageResource(current.getImageID());
            this.pro_name.setText(current.getProduct_name());
            this.pro_des.setText(current.getDescription());
            this.pro_price.setText(""+current.getProduct_price());
            this.position = position;
            this.current=current;
        }
    }
}
