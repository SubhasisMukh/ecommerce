package com.example.rajarshi.herb_o_cure.product_model;

import com.example.rajarshi.herb_o_cure.R;

import java.util.ArrayList;

/**
 * Created by Rajarshi on 7/24/2017.
 */

public class Category_three {


    private int imageID;
    private String product_name;
    private String description;
    private int product_price;

    public int getImageID() {
        return imageID;
    }

    public String getProduct_name() {
        return product_name;
    }

    public String getDescription() {
        return description;
    }

    public int getProduct_price() {
        return product_price;
    }

    public void setImageID(int imageID) {
        this.imageID = imageID;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setProduct_price(int product_price) {
        this.product_price = product_price;
    }

    public static ArrayList<Category_three> getData() {

        ArrayList<Category_three> datalist = new ArrayList<>();
        int[] images = getImages();
        String[] name = getNames();
        String[] des = getDescrition();
        int[] price = getPrice();

        for (int i = 0; i < images.length; i++) {
            Category_three landscape = new Category_three();
            landscape.setImageID(images[i]);
            landscape.setProduct_name(name[i]);
            landscape.setDescription(des[i]);
            landscape.setProduct_price(price[i]);
            datalist.add(landscape);
        }

        return datalist;
    }

    private static int[] getPrice() {
        int pri[] = {100, 200};
        return pri;
    }

    private static String[] getDescrition() {
        String[] descrip = {"Description of e", "Description of f"};
        return descrip;
    }


    public static int[] getImages() {
        int images[] = {R.drawable.e, R.drawable.f};
        return images;
    }

    public static String[] getNames() {
        String names[] = {"Product e", "Product f"};
        return names;
    }


}
