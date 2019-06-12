package com.example.sellme;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Handler;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class SpalshScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spalsh_screen);


        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                SharedPreferences sharedPreferences=getSharedPreferences("FILE" ,Context.MODE_PRIVATE);
                boolean hasRes = sharedPreferences.getBoolean("BOX",false);
                if (hasRes==true) {
                    Intent intent = new Intent(SpalshScreen.this, Main2Activity.class);
                    SpalshScreen.this.startActivity(intent);
                    SpalshScreen.this.finish();
                }else if (hasRes==false){
                    Intent intent = new Intent(SpalshScreen.this, MainActivity.class);
                    SpalshScreen.this.startActivity(intent);
                    SpalshScreen.this.finish();
                }
            }
        },3000);


    }


}
