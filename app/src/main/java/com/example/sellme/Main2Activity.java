package com.example.sellme;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;

public class Main2Activity extends AppCompatActivity {

    TabLayout tabLayout;
    ViewPager viewPager;
    PageAdapter pageAdapter ;
    Toolbar toolbar ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        toolbar = findViewById(R.id.barid);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);


        tabLayout = findViewById(R.id.tabid);
        viewPager=findViewById(R.id.viewpagerid);
        pageAdapter = new PageAdapter(getSupportFragmentManager());


        SharedPreferences sharedPreferences=getSharedPreferences("FILE",Context.MODE_PRIVATE);
        String x= sharedPreferences.getString("USERNAME","Not Avail").toString();
        TextView textView = findViewById(R.id.nameid);
        textView.setText(""+x);
        TextView textView1 = findViewById(R.id.loginasid);
        textView1.append(""+x);

        Button button = findViewById(R.id.logoutid);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences sharedPreferences=getSharedPreferences("FILE",Context.MODE_PRIVATE);
                sharedPreferences.edit().clear().commit();
                Intent intent = new Intent(Main2Activity.this,MainActivity.class);
                startActivity(intent);

            }
        });


        tabLayout.addTab(tabLayout.newTab().setText("VEHICLES").setIcon(R.drawable.car));
        tabLayout.addTab(tabLayout.newTab().setText("Electronics").setIcon(R.drawable.sedan));
        tabLayout.addTab(tabLayout.newTab().setText("Fashion").setIcon(R.drawable.delivery));
        viewPager.setAdapter(pageAdapter);


        //swip from tabs
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.option_menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.item1:onBackPressed();
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
