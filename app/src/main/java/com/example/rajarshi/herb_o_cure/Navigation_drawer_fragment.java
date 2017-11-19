package com.example.rajarshi.herb_o_cure;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.DrawerLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;


public class Navigation_drawer_fragment extends Fragment {

    DrawerLayout drawerlayout;
    ListView listView;
    String username = "Rajarshi";
    TextView tv;

    //nav drawer items

    String text_name[] = {"My Cart", "My Orders", "My account", "Help Centre", "About Us", "FAQ", "Sign in", "Sign out"};

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.navigation_drawer_fragment, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        listView = (ListView) getActivity().findViewById(R.id.listviewfragment);
        CustomAdopter customAdopter = new CustomAdopter();
        listView.setAdapter(customAdopter);
        listView.setTextAlignment(listView.TEXT_ALIGNMENT_CENTER);

        //on select item from nav drawer logic

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                switch (position) {
                    case 0:
                        if (MainActivity.checkguest == 1) {
                            Toast.makeText(getActivity().getApplicationContext(), "Sorry you have to Sign in", Toast.LENGTH_SHORT).show();
                        } else {
                            if (MainActivity.checkguest == 0) {
                                if (Product_home.countforcart >= 1) {
                                    startActivity(new Intent(getActivity().getApplicationContext(), My_cart.class));
                                } else {
                                    startActivity(new Intent(getActivity().getApplicationContext(), My_cart_empty.class));
                                }
                            }
                        }
                        break;
                    case 1:
                        if (MainActivity.checkguest == 1) {
                            Toast.makeText(getActivity().getApplicationContext(), "Sorry you have to Sign in", Toast.LENGTH_SHORT).show();
                        } else {
                            startActivity(new Intent(getActivity().getApplicationContext(), My_Orders.class));
                        }

                        break;
                    case 2:
                        if (MainActivity.checkguest == 1) {
                            Toast.makeText(getActivity().getApplicationContext(), "Sorry you have to Sign in", Toast.LENGTH_SHORT).show();
                        } else {
                            startActivity(new Intent(getActivity().getApplicationContext(), My_account.class));
                        }
                        break;
                    case 3:
                        startActivity(new Intent(getActivity().getApplicationContext(), Help_center.class));
                        break;
                    case 4:
                        startActivity(new Intent(getActivity().getApplicationContext(), About_us.class));

                        break;
                    case 5:
                        startActivity(new Intent(getActivity().getApplicationContext(), Faq.class));

                        break;
                    case 6:
                        if (MainActivity.checkguest == 1) {
                            startActivity(new Intent(getActivity().getApplicationContext(), MainActivity.class));
                            getActivity().finish();
                        } else {
                            Toast.makeText(getActivity().getApplicationContext(), "Sorry you are already Signed in", Toast.LENGTH_SHORT).show();
                        }
                        break;
                    case 7:
                        if (MainActivity.checkguest == 0) {
                            startActivity(new Intent(getActivity().getApplicationContext(), MainActivity.class));
                            Toast.makeText(getActivity().getApplicationContext(), "Successfully Signed out..", Toast.LENGTH_SHORT).show();
                            getActivity().finish();
                        } else {
                            Toast.makeText(getActivity().getApplicationContext(), "You are not Signed in Please Log in", Toast.LENGTH_SHORT).show();
                        }



                        break;

                }

            }
        });
    }



    public void setUp(DrawerLayout drawer) {
        drawerlayout = drawer;
    }


    class CustomAdopter extends BaseAdapter {

        //list view methods ListView is "listviewfragment" and single layout is single_row_list_nav_drawer

        @Override
        public int getCount() {
            return text_name.length;
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
            v = getActivity().getLayoutInflater().inflate(R.layout.single_row_list_nav_drawer, null);
            TextView textView_name = (TextView) v.findViewById(R.id.product_name);
            textView_name.setText(text_name[position]);
            return v;
        }
    }


}
